package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarFactoryService carFactoryService;

    @Autowired
    public CarController(CarFactoryService carFactoryService) {

        this.carFactoryService = carFactoryService;
    }

    @PostMapping(value = "/createCar", consumes= MediaType.TEXT_PLAIN_VALUE)
    public String createCar(@RequestBody String carType) {
        Car car = carFactoryService.createCar(carType);

        if (car != null)
            return car.getType() + " car has produced";
        else
            return "There is no such car type";

    }
}
