package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.AirlineDto;
import com.finartz.ticketHomework.service.AirlineService;
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
class AirlineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AirlineService airlineService;

    @Test
    void getAirlineByIdController() throws Exception {
        AirlineDto airlineDto = new AirlineDto();
        airlineDto.setCode("PGS");
        airlineDto.setName("Pegasus Airlines");
        when(airlineService.getAirlineById(1)).thenReturn(Optional.of(airlineDto));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/airline/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }


    @Test
    void createAirlineControllerTest() {
    }
}