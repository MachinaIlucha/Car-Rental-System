package com.illiapinchuk.carrentalsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CR_car_parameters")
public class CarParameters implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "car_id")
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "body_type")
    private String bodytype;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "power")
    private Integer power;

    @Column(name = "gearbox")
    private String gearbox;

    @Column(name = "front_wheel_drive")
    private Boolean frontWheelDrive;

    @Column(name = "doors_number")
    private Integer doorsNumber;

    @Column(name = "seats_number")
    private Integer seatsNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "metallic")
    private Boolean metallic;

    @Column(name = "description")
    private String description;
}
