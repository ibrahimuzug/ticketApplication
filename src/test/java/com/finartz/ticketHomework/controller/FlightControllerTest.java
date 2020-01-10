package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.FlightDto;
import com.finartz.ticketHomework.service.FlightService;
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
class FlightControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FlightService flightService;

    @Test
    void getFlightById() throws Exception {
        FlightDto flightDto = new FlightDto();
        flightDto.setRouteId(1);
        flightDto.setAirlineId(1);
        flightDto.setPrice(1500.0);
        flightDto.setQuota(300);
        when(flightService.getFlightById(1)).thenReturn(Optional.of(flightDto));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/flight/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }


    @Test
    void createFlight() {
    }
}