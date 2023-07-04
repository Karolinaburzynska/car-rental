package com.example.carrental.domain.car;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface CarService {
    Car addNewCar(Brand brand, String color, LocalDate dateOfProduction, BigDecimal costPerDay);

    Optional<Car> getCar(Long carId);





}
