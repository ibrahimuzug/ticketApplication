package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.AirportDto;
import com.finartz.ticketHomework.service.AirportService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AirportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AirportService airportService;

    @Test
    void getAirportById() throws Exception {
        AirportDto airportDto = new AirportDto();
        airportDto.setCode("IST");
        airportDto.setName("İstanbul Havalimanı");
        when(airportService.getAirportById(1)).thenReturn(Optional.of(airportDto));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/airport/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createAirport() {
    }
}