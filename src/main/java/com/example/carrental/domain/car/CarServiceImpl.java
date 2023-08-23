package com.example.carrental.domain.car;

import com.example.carrental.domain.booking.Booking;
import com.example.carrental.infrastructure.CarRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl  implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addNewCar(Brand brand, String color, LocalDate dateOfProduction, BigDecimal costPerDay) {
        Car car = new Car(brand,dateOfProduction,color,costPerDay);
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> getCar(Long carId) {
        return carRepository.findById(carId);
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }


}
