package com.finartz.ticketHomework.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.ticketHomework.dao.AirportDao;
import com.finartz.ticketHomework.dao.RouteDao;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.entity.Airport;
import com.finartz.ticketHomework.entity.Route;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

class RouteServiceTest {

    @Test
    void getRouteById() {
    }

    @InjectMocks
    Route route;

    @Mock
    RouteDao routeDao;

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAirportById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/route/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createAirport() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/route/create")
                .content(asJsonString(new Airline()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}