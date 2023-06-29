package com.example.carrental.api.employee;

import com.example.carrental.domain.employee.Employee;
import com.example.carrental.domain.employee.Position;

public record EmployeeDto(
        Long id,
        String name,
        String surname,
        Position position

) {
    public static EmployeeDto fromDomain(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getPosition());
    }
}
