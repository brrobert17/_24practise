package com.example._24practise.controller;

import com.example._24practise.entity.Reservation;
import com.example._24practise.service.ReservationService;
import com.example._24practise.service.exception.CarNotAvailableException;
import com.example._24practise.service.exception.ReservationNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    final ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAll (){
        return reservationService.getAll();
    }

    @GetMapping("{id}")
    public Reservation getById(@PathVariable Integer id) throws ReservationNotFoundException {
        return reservationService.getById(id);
    }

    @PostMapping
    public Reservation  create(@RequestBody Reservation reservation) throws CarNotAvailableException {
//        Reservation reservation1 = reservationService.create(reservation);
//        if (reservation1 == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(reservation1,HttpStatus.CREATED);
        return reservationService.create(reservation);
    }

    @PutMapping("{id}")
    public Reservation update(@PathVariable Integer id, @RequestBody Reservation reservation) throws ReservationNotFoundException, CarNotAvailableException {
        return reservationService.update(id, reservation);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable Integer id) throws ReservationNotFoundException {
        reservationService.del(id);
    }

}
