package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.FlightDto;
import com.finartz.ticketHomework.dto.RouteDto;
import com.finartz.ticketHomework.service.FlightService;
import com.finartz.ticketHomework.service.RouteService;
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
class RouteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RouteService routeService;

    @Test
    void getRouteById() throws Exception {
        RouteDto routeDto = new RouteDto();
        routeDto.setCode("1");
        routeDto.setToAirportId(1);
        routeDto.setFromAirportId(1);
        when(routeService.getRouteById(1)).thenReturn(Optional.of(routeDto));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/route/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createRoute() {
    }
}