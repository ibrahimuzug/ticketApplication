package com.finartz.ticketHomework.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finartz.ticketHomework.dto.AirlineDto;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.service.AirlineService;
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

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AirlineServiceImplTest {

    @Mock
    AirlineService airlineServiceMock;
    @InjectMocks
    AirlineServiceImpl airlineServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    private AirlineDto airlineDto;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAirlineByIdServiceImplTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/airline/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createAirlineServiceImplTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/airport/create")
                .content(asJsonString(new Airline()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}