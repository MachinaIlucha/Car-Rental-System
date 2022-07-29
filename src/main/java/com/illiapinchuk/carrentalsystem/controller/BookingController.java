package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.dto.BookingDto;
import com.illiapinchuk.carrentalsystem.model.Booking;
import com.illiapinchuk.carrentalsystem.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/addBooking")
    public Booking addBooking(@ModelAttribute BookingDto bookingDto){
        return bookingService.addBooking(bookingDto);
    }

    @DeleteMapping("/{bookingId}/deleteBooking")
    public void deleteBooking(@PathVariable Long bookingId){
        bookingService.cancelBooking(bookingId);
    }
}
