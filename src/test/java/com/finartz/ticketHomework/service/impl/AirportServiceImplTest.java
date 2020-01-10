package com.finartz.ticketHomework.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.ticketHomework.dto.AirlineDto;
import com.finartz.ticketHomework.dto.AirportDto;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.service.AirlineService;
import com.finartz.ticketHomework.service.AirportService;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AirportServiceImplTest {


    @Mock
    AirportService airportService;
    @InjectMocks
    AirportServiceImpl airportServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    private AirportDto airportDto;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAirportById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/airport/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createAirport() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/airport/create")
                .content(asJsonString(new Airline()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}