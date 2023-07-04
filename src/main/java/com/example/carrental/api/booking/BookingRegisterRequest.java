package com.example.carrental.api.booking;

import java.time.LocalDate;

public record BookingRegisterRequest(
        Long employeeId,
        Long clientId,
        Long carId,
        LocalDate rentDate,
        LocalDate returnDate

) {
}

