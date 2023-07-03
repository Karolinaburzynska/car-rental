package com.example.carrental.api.car;

import com.example.carrental.domain.car.Brand;
import com.example.carrental.domain.car.Car;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CarDto(
        Long carId,
        Brand brand,
        LocalDate dateOfProduction,
        String color,
        BigDecimal costPerDay

) {

    public static CarDto fromDomain(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getDateOfProduction(),
                car.getColor(),
                car.getCostPerDay()
        );

    }
}
