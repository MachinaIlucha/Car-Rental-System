package com.illiapinchuk.carrentalsystem.dto;

import lombok.Data;

@Data
public class BookingDto {
    private Long userId;
    private Long carId;
    private Long locationId;
    private String receiptDate;
    private String returnDate;
}
