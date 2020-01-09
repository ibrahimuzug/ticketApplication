package com.finartz.ticketHomework.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.ticketHomework.dao.AirlineDao;
import com.finartz.ticketHomework.entity.Airline;
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

class AirlineServiceTest {

    @InjectMocks
    Airline airline;

    @Mock
    AirlineDao airlineDao;

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
    void getAirlineById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/airline/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createAirline() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/airline/create")
                .content(asJsonString(new Airline("3", "Pegasus Airlines", "PGS")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}