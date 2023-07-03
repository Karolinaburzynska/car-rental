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

    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)

    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)

    private Car car;
    private Status carStatus = Status.AVAILABLE;

    private LocalDate rentDate;

    private LocalDate returnDate;


    public Booking() {
    }

    public Booking(Long id, Employee employee, Client client, Car car, Status carStatus, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.employee = employee;
        this.client = client;
        this.car = car;
        this.carStatus = carStatus;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employeeId) {
        this.employee = employeeId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client clientId) {
        this.client = clientId;
    }

    public Car getCarId() {
        return car;
    }

    public void setCarId(Car car) {
        this.car = car;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Status getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Status carStatus) {
        this.carStatus = carStatus;
    }
}
