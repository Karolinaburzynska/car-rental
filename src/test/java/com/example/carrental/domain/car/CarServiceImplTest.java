package com.example.carrental.domain.car;

import com.example.carrental.infrastructure.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;


    @Test
    void should_add_new_car() {
        // given
        Car carToAdd = new Car();
        carToAdd.setBrand(Brand.JAGUAR);
        carToAdd.setColor("blue");
        carToAdd.setDateOfProduction(LocalDate.of(2020, 1, 1));
        carToAdd.setCostPerDay(BigDecimal.valueOf(400));

        Mockito.when(carRepository.save(any(Car.class))).thenReturn(carToAdd);

        // when
        Car addedCar = carService.addNewCar(Brand.JAGUAR, "blue", LocalDate.of(2020, 1, 1), BigDecimal.valueOf(400));

        // then
        assertThat(addedCar).isEqualTo(carToAdd);
    }


}