package com.illiapinchuk.carrentalsystem.repository;

import com.illiapinchuk.carrentalsystem.model.Booking;
import com.illiapinchuk.carrentalsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> getBookingsByUser(User user);
}
