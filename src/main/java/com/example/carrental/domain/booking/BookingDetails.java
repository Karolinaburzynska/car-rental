package com.example.carrental.domain.booking;

import com.example.carrental.domain.car.Car;
import com.example.carrental.domain.client.Client;

import java.math.BigDecimal;

public record BookingDetails(
        Long bookingId,
        Car carId,
        Client clientId,
        BigDecimal totalSum
) {
}
