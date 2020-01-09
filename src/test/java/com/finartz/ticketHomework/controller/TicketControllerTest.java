package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.TicketDto;
import com.finartz.ticketHomework.service.TicketService;
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
class TicketControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TicketService ticketService;

    @Test
    void getTicketById() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicketNumber(123456);
        ticketDto.setFlightId(1);
        ticketDto.setDate(01.01.1995);
        ticketDto.setTime(11:25);
        ticketDto.setPrice(1550.0);
        when(ticketService.getTicketByTicketNumber(1)).thenReturn(Optional.of(ticketDto));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/ticket/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createTicket() {
    }

    @Test
    void deleteTicket() {
    }
}