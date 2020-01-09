package com.finartz.ticketHomework.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.ticketHomework.dto.FlightDto;
import com.finartz.ticketHomework.dto.RouteDto;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.service.FlightService;
import com.finartz.ticketHomework.service.RouteService;
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
class RouteServiceImplTest {

    @Mock
    RouteService routeService;
    @InjectMocks
    RouteServiceImpl routeServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    private RouteDto routeDto;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getRouteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/route/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createRoute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/route/create")
                .content(asJsonString(new Airline("IST-BAT", "1", "5")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}