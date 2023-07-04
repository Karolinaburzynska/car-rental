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

import java.time.LocalDate;

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
}
