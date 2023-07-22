package com.example.carrental.domain.department;

import com.example.carrental.domain.car.Car;
import com.example.carrental.domain.employee.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Car> cars;

}
