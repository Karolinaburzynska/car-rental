package com.example.carrental.api;

import com.example.carrental.domain.employee.Employee;
import com.example.carrental.domain.employee.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.carrental.api.EmployeeController.BASE_PATH_EMPLOYEE;

@RestController
@RequestMapping(BASE_PATH_EMPLOYEE)
public class EmployeeController {

    static final String BASE_PATH_EMPLOYEE = "/employees";

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> registerNewEmployee(@RequestBody EmployeeRegisterRequest request) {
        Employee newEmployee = employeeService.registerNewEmployee(request.name(), request.surname(), request.position());
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }
}

