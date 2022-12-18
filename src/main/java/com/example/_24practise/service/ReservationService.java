package com.example._24practise.service;

import com.example._24practise.entity.Car;
import com.example._24practise.entity.Reservation;
import com.example._24practise.repo.CarRepo;
import com.example._24practise.repo.ReservationRepo;
import com.example._24practise.service.exception.CarNotAvailableException;
import com.example._24practise.service.exception.ReservationNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    final ReservationRepo reservationRepo;
    final CarRepo carRepo;

    public Reservation create(Reservation reservation) throws CarNotAvailableException {
        List<Car> cars = carRepo.findAvailable(reservation.getRentalDate());
        for (Car car : cars
        ) {
            if (reservation.getCar().getId() == car.getId()) {
                return reservationRepo.save(reservation);
            }
        }
        throw new CarNotAvailableException("car not available");
    }

    public List<Reservation> getAll() {
        return reservationRepo.findAll();
    }

    public Reservation update(Integer id, Reservation reservation) throws ReservationNotFoundException, CarNotAvailableException {
        Optional<Reservation> optionalReservation = reservationRepo.findById(id);

        if (optionalReservation.isPresent()) {
            Reservation old = optionalReservation.get();
            System.out.println(old.getCar().getId());
            System.out.println(reservation.getCar().getId());
            System.out.println(old.getRentalDate());
            System.out.println(reservation.getRentalDate());
            if ((old.getCar().getId() == reservation.getCar().getId()) && (old.getRentalDate().equals(reservation.getRentalDate()))) {
                System.out.println("hey");
                return reservationRepo.save(reservation);
            } else {
                List<Car> cars = carRepo.findAvailable(reservation.getRentalDate());
                for (Car car : cars
                ) {
                    if (reservation.getCar().getId() == car.getId()) {
                        return reservationRepo.save(reservation);
                    }
                }
                throw new CarNotAvailableException("car not available");
            }
        }
        throw new ReservationNotFoundException("reservation not found by id: " + id);
    }

    public Reservation getById(Integer id) throws ReservationNotFoundException {
        return reservationRepo.findById(id).orElseThrow(
                () -> new ReservationNotFoundException("reservation not found by id: " + id));

    }

    public void del(Integer id) throws ReservationNotFoundException {
        reservationRepo.findById(id).orElseThrow(() -> new ReservationNotFoundException("reservation not found by id: " + id));
        reservationRepo.deleteById(id);
    }


}
