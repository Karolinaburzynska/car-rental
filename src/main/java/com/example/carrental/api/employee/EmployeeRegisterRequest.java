package com.example.carrental.api.employee;

import com.example.carrental.domain.employee.Position;

public record EmployeeRegisterRequest(String name,
                                      String surname,
                                      Position position) {
}
