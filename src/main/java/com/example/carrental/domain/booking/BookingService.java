package com.example.carrental.domain.booking;

import java.time.LocalDate;
import java.util.Optional;

public interface BookingService {

    Booking addNewBooking(long employeeId, long clientId, long carId, LocalDate rentDate, LocalDate returnDate) throws BookingUnavailableVehicleException;
    Optional<BookingDetails> getBookingDetails(Long bookingId);
}
