package com.example.carrental.domain.employee;

import com.example.carrental.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee registerNewEmployee(String name, String surname, Position position) {
        Employee newEmployee = new Employee(name, surname, position);
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Optional<Employee> getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
