package com.illiapinchuk.carrentalsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "CR_comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "login")
    private String login;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "rating")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="car_id", nullable=false)
    private Car car;

    @PrePersist
    public void prePersist(){
        creationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
