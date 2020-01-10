package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.TicketDto;
import com.finartz.ticketHomework.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{ticketNumber}")
    public @ResponseBody
    Optional<TicketDto> getTicketByTicketNumber(@PathVariable("ticketNumber") Integer ticketNumber) {
        return ticketService.getTicketByTicketNumber(ticketNumber);
    }

    @PostMapping("/create")
    public void createTicket(@RequestBody TicketDto ticketDto) {
        ticketService.createTicket(ticketDto);
    }

    @DeleteMapping("/delete/{ticketNumber}")
    public void deleteTicket(@PathVariable("ticketNumber") Integer ticketNumber) {
        ticketService.deleteTicket(ticketNumber);
    }
}
