package com.illiapinchuk.carrentalsystem.service;

import com.illiapinchuk.carrentalsystem.dto.BookingDto;
import com.illiapinchuk.carrentalsystem.exception.BookingUnavailableCarException;
import com.illiapinchuk.carrentalsystem.model.Booking;
import com.illiapinchuk.carrentalsystem.model.Car;
import com.illiapinchuk.carrentalsystem.model.Location;
import com.illiapinchuk.carrentalsystem.model.User;
import com.illiapinchuk.carrentalsystem.repository.BookingRepository;
import com.illiapinchuk.carrentalsystem.repository.LocationRepository;
import com.illiapinchuk.carrentalsystem.service.interfaces.BookingService;
import com.illiapinchuk.carrentalsystem.service.interfaces.CarService;
import com.illiapinchuk.carrentalsystem.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    @Qualifier("carService")
    private CarService carService;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Override
    @Transactional
    public Booking addBooking(BookingDto bookingDto) throws BookingUnavailableCarException {
        Car car = carService.getCarById(bookingDto.getCarId());

        if (car.getCarStatus())
            throw new BookingUnavailableCarException();
        car.setCarStatus(true);

        Location location = locationRepository.getReferenceById(bookingDto.getLocationId());
        User user = userService.getUserById(bookingDto.getUserId());

        Booking booking = new Booking();
        booking.setCar(car);
        booking.setLocation(location);
        booking.setUser(user);
        booking.setReceiptDate(bookingDto.getReceiptDate());
        booking.setReturnDate(bookingDto.getReturnDate());
        booking.setTotalCost(getTotalCost(bookingDto.getReceiptDate(), booking.getReturnDate(), car.getDailyFee()));

        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.getReferenceById(bookingId);
        booking.getCar().setCarStatus(false);

        bookingRepository.deleteById(bookingId);
    }

    @Override
    public Booking getBookingsById(Long bookingId) {
        return bookingRepository.getReferenceById(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        User user = userService.getUserById(userId);
        return bookingRepository.getBookingsByUser(user);
    }

    private double getTotalCost(String receiptDate, String returnDate, Integer dailyFee){
        //Calculate days between two dates
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime date1 = LocalDate.parse(receiptDate, dtf).atStartOfDay();
        LocalDateTime date2 = LocalDate.parse(returnDate, dtf).atStartOfDay();
        long daysBetween = Duration.between(date1, date2).toDays();

        return dailyFee * daysBetween;
    }
}
