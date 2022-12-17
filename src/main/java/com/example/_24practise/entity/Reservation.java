package com.example._24practise.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
