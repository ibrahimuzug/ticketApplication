package com.finartz.ticketHomework.ticket;

import com.finartz.ticketHomework.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{ticketNumber}")
    public @ResponseBody
    Optional<Ticket> getTicketByTicketNumber(@PathVariable("ticketNumber") Integer ticketNumber) {
        return ticketService.getTicketByTicketNumber(ticketNumber);
    }
}
