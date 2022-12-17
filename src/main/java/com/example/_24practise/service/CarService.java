package com.example._24practise.service;

import com.example._24practise.entity.Car;
import com.example._24practise.repo.CarRepo;
import com.example._24practise.service.exception.CarNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    final CarRepo carRepo;

    public Car create(Car car) {
        return carRepo.save(car);
    }

    public Car getById(Integer id) throws CarNotFoundException {
        return carRepo.findById(id).orElseThrow(() -> new CarNotFoundException("car not found by id: " + id));
    }

    public List<Car> getAll() {
        return carRepo.findAll();
    }

    public Car update(Integer id, Car car) throws CarNotFoundException {
        carRepo.findById(id).orElseThrow(() -> new CarNotFoundException("car not found by id: " + id));
        return carRepo.save(car);
    }

    public void del(Integer id) throws CarNotFoundException {
        carRepo.findById(id).orElseThrow(() -> new CarNotFoundException("car not found by id: " + id));
        carRepo.deleteById(id);
    }


}
