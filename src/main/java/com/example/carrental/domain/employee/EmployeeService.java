package com.example.carrental.domain.employee;

import java.util.Optional;

public interface EmployeeService {

    Employee registerNewEmployee(String name, String surname, Position position);
    Optional<Employee> getEmployee(Long employeeId);

}
