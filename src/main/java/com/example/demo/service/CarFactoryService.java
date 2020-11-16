package com.example.demo.service;

import com.example.demo.model.Cabrio;
import com.example.demo.model.Car;
import com.example.demo.model.Hatchback;
import com.example.demo.model.Sedan;
import org.springframework.stereotype.Service;

@Service
public class CarFactoryService {

    public Car createCar(String carType) {
        if (carType.equalsIgnoreCase("Sedan"))
            return new Sedan();
        else if (carType.equalsIgnoreCase("Cabrio"))
            return new Cabrio();
        else if (carType.equalsIgnoreCase("Hatchback"))
            return new Hatchback();
        else
            return null;

    }
}
