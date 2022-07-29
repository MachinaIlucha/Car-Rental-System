package com.illiapinchuk.carrentalsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "CR_cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "registration")
    private String registration;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "daily_fee")
    private Integer dailyFee;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "vehicle_status")
    private Boolean carStatus;

    @OneToOne(mappedBy = "car")
    private CarParameters carParameters;

    @JsonIgnore
    @OneToMany(mappedBy="car")
    private Set<Comment> comments;
}
