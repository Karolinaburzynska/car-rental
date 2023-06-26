package com.example.carrental.domain.booking;

import com.example.carrental.domain.car.Car;
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

    private LocalDate rentDate;

    private LocalDate returnDate;




    public Booking() {
    }

    public Booking(Employee employeeId, Client clientId, Car car, LocalDate rentDate, LocalDate returnDate) {
        this.employee = employeeId;
        this.client = clientId;
        this.car = car;
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

}
