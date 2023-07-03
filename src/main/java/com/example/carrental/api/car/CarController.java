package com.example.carrental.api.car;

import com.example.carrental.domain.car.Car;
import com.example.carrental.domain.car.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.carrental.api.car.CarController.BASE_PATH_CAR;

@RestController
@RequestMapping(BASE_PATH_CAR)
public class CarController {

    static final String BASE_PATH_CAR = "/cars";

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }


    @PostMapping
    public ResponseEntity<Car> addNewCar(@RequestBody @Valid CarRegisterRequest request) {
        Car newCar = carService.addNewCar(request.brand(), request.color(), request.dateOfProduction(), request.status(), request.costPerDay());
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }
    @GetMapping("/{carId}")
    ResponseEntity<CarDto> getSingleCar(@PathVariable Long carId){
        return ResponseEntity.of(carService.getCar(carId).map(CarDto::fromDomain));
    }
}

