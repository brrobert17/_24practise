package com.example._24practise.controller;

import com.example._24practise.entity.Car;
import com.example._24practise.entity.Car;
import com.example._24practise.repo.CarRepo;
import com.example._24practise.service.CarService;
import com.example._24practise.service.exception.CarNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    final CarService carService;

    @GetMapping
    public List<Car> getAll (){
        return carService.getAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable Integer id) throws CarNotFoundException {
        return carService.getById(id);
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping("{id}")
    public Car update(@PathVariable Integer id, @RequestBody Car car) throws CarNotFoundException {
        return carService.update(id, car);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable Integer id) throws CarNotFoundException {
        carService.del(id);
    }
}
