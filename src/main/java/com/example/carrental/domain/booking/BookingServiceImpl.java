package com.example.carrental.domain.booking;

import com.example.carrental.domain.car.Car;
import com.example.carrental.domain.car.CarServiceImpl;
import com.example.carrental.domain.client.Client;
import com.example.carrental.domain.employee.Employee;
import com.example.carrental.infrastructure.BookingRepository;
import com.example.carrental.infrastructure.CarRepository;
import com.example.carrental.infrastructure.ClientRepository;
import com.example.carrental.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final EmployeeRepository employeeRepository;
    private final CarServiceImpl carService;

    public BookingServiceImpl(BookingRepository bookingRepository, ClientRepository clientRepository, CarRepository carRepository, EmployeeRepository employeeRepository, CarServiceImpl carService) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
        this.carService = carService;
    }

    @Override
    public Booking addNewBooking(long employeeId, long clientId, long carId, LocalDate rentDate, LocalDate returnDate) throws BookingUnavailableVehicleException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        Client client = clientRepository.findById(clientId).orElseThrow();
        Car car = carRepository.findById(carId).orElseThrow();

        if (car.isAvailableForDateRange(rentDate,returnDate)){
            Booking newBooking = new Booking(employee, client, car, rentDate, returnDate);
            return bookingRepository.save(newBooking);
        }else {
            throw new BookingUnavailableVehicleException("Cannot book rent vehicle.");
        }
    }

    @Override
    public Optional<BookingDetails> getBookingDetails(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        BigDecimal calculateSumOf = calculateSumOf(booking);
        return booking.map(foundBooking -> new BookingDetails(
                foundBooking.getId(),
                foundBooking.getCarId(),
                foundBooking.getClientId(),
                calculateSumOf
        ));
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    private static BigDecimal calculateSumOf(Optional<Booking> booking) {

        Duration difference = Duration.between(booking.get().getRentDate().atStartOfDay(), booking.get().getReturnDate().atStartOfDay());
        int days = (int) difference.toDays();
        BigDecimal costPerDay = booking.get().getCarId().getCostPerDay();
        BigDecimal totalSum = costPerDay.multiply(BigDecimal.valueOf(days));
        return totalSum;
    }


}
