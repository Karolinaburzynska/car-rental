package com.example.carrental.infrastructure;

import com.example.carrental.domain.booking.Booking;
import com.example.carrental.domain.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
