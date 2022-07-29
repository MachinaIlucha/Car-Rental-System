package com.illiapinchuk.carrentalsystem.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String registration;
    private String brand;
    private String model;
    private Integer dailyFee;
    private Long location;
    private Boolean vehicleStatus;

    private String bodytype;
    private Integer productionYear;
    private String fuelType;
    private Integer power;
    private String gearbox;
    private Boolean frontWheelDrive;
    private Integer doorsNumber;
    private Integer seatsNumber;
    private String color;
    private Boolean metallic;
    private String description;
}
