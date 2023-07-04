package com.example.carrental.api.booking;

import com.example.carrental.domain.booking.BookingServiceImpl;
import com.example.carrental.domain.booking.BookingUnavailableVehicleException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.example.carrental.domain.booking.Booking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import static com.example.carrental.api.booking.BookingController.BASE_PATH_BOOKING;

@RestController
@RequestMapping(BASE_PATH_BOOKING)
public class BookingController {

    static final String BASE_PATH_BOOKING = "/bookings";

    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping
    public ResponseEntity<BookingResponseDto> addNewBooking(@RequestBody @Valid BookingRegisterRequest request) throws BookingUnavailableVehicleException {
        Booking newBooking = bookingService.addNewBooking(request.employeeId(), request.clientId(), request.carId(), request.rentDate(), request.returnDate());
        BookingResponseDto bookingResponseDto = BookingResponseDto.fromDomain(newBooking);
        return ResponseEntity.created(URI.create("/bookings" + bookingResponseDto.bookingId())).body(bookingResponseDto);
    }

}
