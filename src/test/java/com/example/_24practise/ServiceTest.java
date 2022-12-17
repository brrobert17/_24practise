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
import com.example._24practise.service.exception.ReservationNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class ServiceTest {

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

    @BeforeEach
    void setUp() {
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

    @Test
    void addReservation() {
        reservation = Reservation.builder().reservationDate(LocalDate.of(2022,12,15))
                .rentalDate(LocalDate.of(2022,12,28)).car(car).member(member).build();
        Integer id = reservationService.create(reservation).getId();
        Assertions.assertThat(reservationRepo.findById(id).get().getReservationDate()).isEqualTo(reservation.getReservationDate());
    }

    @Test
    public void testListAll() {
        Assertions.assertThat(reservationService.getAll()).hasSize(3);
    }

    @Test
    public void testGet() throws ReservationNotFoundException {
        Assertions.assertThat(reservationService.getById(2)).isNotNull();
    }

    @Test
    public void testDelete() throws ReservationNotFoundException {
        List<Reservation> reservations = reservationRepo.findAll();
        int reservationIndex = reservations.size() - 1;
        Reservation reservation = reservations.get(reservationIndex);
        Integer id = reservation.getId();
        reservationRepo.deleteById(id);
        Assertions.assertThat(reservationRepo.findById(id)).isNotPresent();
    }

    @Test
    public void testEdit() throws ReservationNotFoundException {
        List<Reservation> reservations = reservationRepo.findAll();
        int reservationIndex = reservations.size() - 1;
        Reservation reservation = reservations.get(reservationIndex);
        Integer id = reservation.getId();
        reservation.setReservationDate(LocalDate.of(2022,11,11));
        reservationRepo.save(reservation);
        Assertions.assertThat(reservationRepo.findById(id).get().getReservationDate()).isEqualTo(LocalDate.of(2022,11,11));
    }


}

