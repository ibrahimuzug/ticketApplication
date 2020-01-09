package com.finartz.ticketHomework.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.ticketHomework.dto.AirportDto;
import com.finartz.ticketHomework.dto.FlightDto;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.service.AirportService;
import com.finartz.ticketHomework.service.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class FlightServiceImplTest {

    @Mock
    FlightService flightService;
    @InjectMocks
    FlightServiceImpl flightServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    private FlightDto flightDto;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getFlightById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/flight/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createFlight() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/airport/create")
                .content(asJsonString(new Airline("3", "1", "550", "1252")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}