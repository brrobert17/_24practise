package com.example._24practise;

import com.example._24practise.entity.Car;
import com.example._24practise.entity.Member;
import com.example._24practise.entity.Reservation;
import com.example._24practise.repo.CarRepo;
import com.example._24practise.repo.MemberRepo;
import com.example._24practise.repo.ReservationRepo;
import com.example._24practise.service.CarService;
import com.example._24practise.service.MemberService;
import com.example._24practise.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class Init {

    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    CarRepo carRepo;
    @Autowired
    CarService carService;
    @Autowired
    MemberRepo memberRepo;
    @Autowired
    MemberService memberService;

    Reservation reservation;
    Car car;
    Member member;

    @Test
    void initialize() {
        reservationRepo.deleteAll();
        carRepo.deleteAll();
        memberRepo.deleteAll();

        car = Car.builder().brand("Opel").model("Astra").bestDiscount(10).pricePerDay(100).build();
        carRepo.save(car);
        member = Member.builder().firstName("Tim").lastName("Tom").approved(true).city("city")
                .ranking(80).street("street").zip(1000).build();
        memberRepo.save(member);
        reservation = Reservation.builder().reservationDate(LocalDate.now())
                .rentalDate(LocalDate.of(2023,12,30)).car(car).member(member).build();
        reservationRepo.save(reservation);

        car = Car.builder().brand("Benz").model("c220").bestDiscount(20).pricePerDay(200).build();
        carRepo.save(car);
        member = Member.builder().firstName("Ben").lastName("Bon").approved(true).city("city2")
                .ranking(90).street("street2").zip(2000).build();
        memberRepo.save(member);
        reservation = Reservation.builder().reservationDate(LocalDate.now())
                .rentalDate(LocalDate.of(2023,12,31)).car(car).member(member).build();
        reservationRepo.save(reservation);

        car = Car.builder().brand("Subaru").model("Impreza").bestDiscount(30).pricePerDay(300).build();
        carRepo.save(car);
        member = Member.builder().firstName("Sam").lastName("Son").approved(true).city("city3")
                .ranking(100).street("street3").zip(3000).build();
        memberRepo.save(member);
        reservation = Reservation.builder().reservationDate(LocalDate.now())
                .rentalDate(LocalDate.of(2023,12,29)).car(car).member(member).build();
        reservationRepo.save(reservation);

    }
}
