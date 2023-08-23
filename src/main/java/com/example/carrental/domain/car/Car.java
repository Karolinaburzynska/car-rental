package com.example.carrental.domain.car;

import com.example.carrental.domain.booking.Booking;
import com.example.carrental.domain.department.Department;
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

    @Column(name = "cost_per_day")
    private BigDecimal costPerDay;
/*
    @Column(name = "department")
    private Department department;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    private List<Booking> bookings;


    public Car() {
    }

    public Car(Long id, Brand brand, LocalDate dateOfProduction, String color, BigDecimal costPerDay) {
        this.id = id;
        this.brand = brand;
        this.dateOfProduction = dateOfProduction;
        this.color = color;
        this.costPerDay = costPerDay;

    }

    public Car(Brand brand, LocalDate dateOfProduction, String color, BigDecimal costPerDay) {
        this.brand = brand;
        this.dateOfProduction = dateOfProduction;
        this.color = color;
        this.costPerDay = costPerDay;
       // this.department = department;
    }


    public boolean isAvailableForDateRange(LocalDate startDate, LocalDate endDate) {

        for (Booking booking : bookings) {
            if (startDate.isBefore(booking.getReturnDate()) && endDate.isAfter(booking.getRentDate())) {
                return false; // Samochód niedostępny w wybranym terminie
            }
        }
        return true;
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

    public BigDecimal getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(BigDecimal costPerDay) {
        this.costPerDay = costPerDay;
    }


}
