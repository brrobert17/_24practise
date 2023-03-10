package com.example._24practise.repo;

import com.example._24practise.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer > {

    @Query(nativeQuery = true, value = "select * from car where id not in (select distinct car_id from reservation where rental_date =:date);")
    List<Car> findAvailable (@Param("date") LocalDate date);
}
