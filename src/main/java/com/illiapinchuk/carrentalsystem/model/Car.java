package com.illiapinchuk.carrentalsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
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

    @OneToOne(mappedBy = "car", fetch = FetchType.LAZY)
    private CarParameters carParameters;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Set<Comment> comments;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", registration='" + registration + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", dailyFee=" + dailyFee +
                ", carStatus=" + carStatus +
                '}';
    }
}
