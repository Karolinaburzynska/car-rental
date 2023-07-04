package com.example.carrental.domain.booking;

import java.time.LocalDate;

public interface BookingService {

    Booking addNewBooking(long employeeId, long clientId, long carId, LocalDate rentDate, LocalDate returnDate) throws BookingUnavailableVehicleException;
}
