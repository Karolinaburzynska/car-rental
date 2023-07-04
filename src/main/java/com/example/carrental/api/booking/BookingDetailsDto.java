package com.example.carrental.api.booking;

import com.example.carrental.domain.booking.BookingDetails;

import java.math.BigDecimal;

public record BookingDetailsDto(
        Long bookingId,
        Long carId,
        Long clientId,
        BigDecimal totalSum
) {
    public static BookingDetailsDto fromDomain(BookingDetails bookingDetails){
        return new BookingDetailsDto(
                bookingDetails.bookingId(),
                bookingDetails.carId().getId(),
                bookingDetails.clientId().getId(),
                bookingDetails.totalSum()
        );
    }
}
