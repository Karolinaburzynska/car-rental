package com.example.carrental.api.booking;

import com.example.carrental.domain.booking.Booking;

import java.time.LocalDate;

public record BookingResponseDto(
        Long bookingId,
        Long employeeId,
        Long clientId,
        Long carId,
        LocalDate rentDate,
        LocalDate returnDate
) {


    public static BookingResponseDto fromDomain(Booking booking) {
        return new BookingResponseDto(
                booking.getId(),
                booking.getEmployeeId().getId(),
                booking.getClientId().getId(),
                booking.getCarId().getId(),
                booking.getRentDate(),
                booking.getReturnDate()
        );
    }
}
