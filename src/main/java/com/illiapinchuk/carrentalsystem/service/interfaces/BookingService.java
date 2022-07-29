package com.illiapinchuk.carrentalsystem.service.interfaces;

import com.illiapinchuk.carrentalsystem.dto.BookingDto;
import com.illiapinchuk.carrentalsystem.exception.BookingUnavailableCarException;
import com.illiapinchuk.carrentalsystem.model.Booking;

import java.util.List;

public interface BookingService {

    Booking addBooking(BookingDto bookingDto) throws BookingUnavailableCarException;

    void cancelBooking(Long bookingId);

    Booking getBookingsById(Long bookingId);

    List<Booking> getAllBookings();

    List<Booking> getUserBookings(Long userId);
}
