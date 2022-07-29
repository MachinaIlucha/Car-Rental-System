package com.illiapinchuk.carrentalsystem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CR_locations")
public class Location {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String addres;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

}
