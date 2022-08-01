package com.illiapinchuk.carrentalsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CR_bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "receipt_date")
    private String receiptDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "total_cost")
    private Double totalCost;
}
