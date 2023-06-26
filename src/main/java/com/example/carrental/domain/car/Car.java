package com.example.carrental.domain.car;

import com.example.carrental.domain.booking.Booking;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "brand")
    private Brand brand;
    @Column(name = "date_of_production")
    private LocalDate dateOfProduction;
    @Column(name = "color")
    private String color;
    @Column(name = "status")
    private Status status;
    @Column(name = "cost_per_day")
    private BigDecimal costPerDay;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Booking> bookings;


    public Car() {
    }

    public Car(Brand brand, LocalDate dateOfProduction, String color, Status status, BigDecimal costPerDay) {
        this.brand = brand;
        this.dateOfProduction = dateOfProduction;
        this.color = color;
        this.status = status;
        this.costPerDay = costPerDay;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(BigDecimal costPerDay) {
        this.costPerDay = costPerDay;
    }

}
