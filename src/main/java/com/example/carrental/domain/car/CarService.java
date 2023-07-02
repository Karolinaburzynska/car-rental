package com.example.carrental.domain.car;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CarService {
    Car addNewCar(Brand brand, String color, LocalDate dateOfProduction, Status status, BigDecimal costPerDay);
}
