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
        member = Member.builder().firstName("fName").lastName("lName").approved(true).city("city")
                .ranking(100).street("street").zip(2000).build();
        memberRepo.save(member);
        reservation = Reservation.builder().reservationDate(LocalDate.of(2022,12,15))
                .rentalDate(LocalDate.of(2022,12,30)).car(car).member(member).build();
        reservationRepo.save(reservation);

        car = Car.builder().brand("Benz").model("c220").bestDiscount(10).pricePerDay(100).build();
        carRepo.save(car);
        member = Member.builder().firstName("fName2").lastName("lName2").approved(true).city("city")
                .ranking(100).street("street").zip(2000).build();
        memberRepo.save(member);
        reservation = Reservation.builder().reservationDate(LocalDate.of(2022,12,15))
                .rentalDate(LocalDate.of(2022,12,31)).car(car).member(member).build();
        reservationRepo.save(reservation);

        car = Car.builder().brand("Subaru").model("Impreza").bestDiscount(10).pricePerDay(100).build();
        carRepo.save(car);
        member = Member.builder().firstName("fName3").lastName("lName3").approved(true).city("city")
                .ranking(100).street("street").zip(2000).build();
        memberRepo.save(member);
        reservation = Reservation.builder().reservationDate(LocalDate.of(2022,12,15))
                .rentalDate(LocalDate.of(2022,12,29)).car(car).member(member).build();
        reservationRepo.save(reservation);

    }
}
