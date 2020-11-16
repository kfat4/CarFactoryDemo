package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.Sedan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarFactoryServiceTest {

    @Mock
    private CarFactoryService carFactoryService;

    @Test
    void createCarShouldReturnACar(){
        final String carType = "sedan";
        Car sedanCar = new Sedan();

        when(carFactoryService.createCar(carType)).thenReturn(sedanCar);
        Car producedCarByService = carFactoryService.createCar(carType);

        assertEquals(sedanCar, producedCarByService);

    }
}
