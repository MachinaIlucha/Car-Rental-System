package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.dto.BookingDto;
import com.illiapinchuk.carrentalsystem.model.Booking;
import com.illiapinchuk.carrentalsystem.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId){
        return bookingService.getBookingsById(bookingId);
    }

    @GetMapping
    public List<Booking> getListOfBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/users/{userId}")
    public List<Booking> getUserBookings(@PathVariable Long userId){
        return bookingService.getUserBookings(userId);
    }

    @PostMapping("/addBooking")
    public Booking addBooking(@ModelAttribute BookingDto bookingDto){
        return bookingService.addBooking(bookingDto);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId){
        bookingService.cancelBooking(bookingId);
    }
}
