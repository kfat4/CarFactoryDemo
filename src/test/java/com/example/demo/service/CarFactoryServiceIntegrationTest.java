package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.Sedan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CarFactoryServiceIntegrationTest {

    @Autowired
    CarFactoryService carFactoryService;

    @Test
    void createCarShouldReturnACar() {
        final String carType = "sedan";
        Car sedanCar = new Sedan();
        Car producedCarByService = carFactoryService.createCar(carType);

        Assertions.assertNotNull(producedCarByService);
        Assertions.assertEquals(sedanCar.getType(), producedCarByService.getType());
    }
}
