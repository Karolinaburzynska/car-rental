package com.example.carrental.api.car;

import com.example.carrental.domain.car.Brand;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CarRegisterRequest(
        Brand brand,
        LocalDate dateOfProduction,
        String color,
        @Positive
        BigDecimal costPerDay

) {
}