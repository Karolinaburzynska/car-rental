package com.example.carrental.domain.car;

import com.example.carrental.infrastructure.CarRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CarServiceImpl  implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addNewCar(Brand brand, String color, LocalDate dateOfProduction, Status status, BigDecimal costPerDay) {
        Car car = new Car(brand,  dateOfProduction,color,status,costPerDay);
        return carRepository.save(car);
    }
}
