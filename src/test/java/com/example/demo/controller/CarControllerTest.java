package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.model.Sedan;
import com.example.demo.service.CarFactoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarFactoryService carFactoryService;

    @Test
    void createCarShouldReturnMessageFromCarService() throws Exception {
        final String carType = "sedan";
        final String controllerOutput = "Sedan car has produced";
        final Car serviceOutput = new Sedan();

        when(carFactoryService.createCar(carType)).thenReturn(serviceOutput);

        this.mockMvc.perform(post("/createCar")
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content(carType))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(controllerOutput)));
    }
}
