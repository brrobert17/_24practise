package com.example._24practise.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    private String firstName;

    private String lastName;

    private String city;

    private String street;

    private int zip;

    private boolean approved;

    private int ranking;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private Set<Reservation> reservationSet = new HashSet<>();
}
