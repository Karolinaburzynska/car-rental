package com.example.carrental.domain.booking;

import com.example.carrental.domain.car.Car;
import com.example.carrental.domain.car.Status;
import com.example.carrental.domain.employee.Employee;
import com.example.carrental.domain.client.Client;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)

    private Employee employeeId;
    @ManyToOne(fetch = FetchType.LAZY)

    private Client clientId;
    @ManyToOne(fetch = FetchType.LAZY)

    private Car carId;
    private Status carStatus;

    private LocalDate rentDate;

    private LocalDate returnDate;


    public Booking() {
    }

    public Booking( Employee employee, Client client, Car car, LocalDate rentDate, LocalDate returnDate) {
        this.employeeId = employee;
        this.clientId = client;
        this.carStatus = Status.RENT;
        this.carId = car;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    public Status getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Status carStatus) {
        this.carStatus = carStatus;
    }
}
