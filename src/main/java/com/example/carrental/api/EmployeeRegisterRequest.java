package com.example.carrental.api;

import com.example.carrental.domain.employee.Position;

public record EmployeeRegisterRequest(String name,
                                      String surname,
                                      Position position) {
}
