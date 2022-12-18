package com.example._24practise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(exclude = "reservationSet")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    private String brand;

    private String model;

    private int pricePerDay;

    private int bestDiscount;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Set<Reservation> reservationSet = new HashSet<>();
}
