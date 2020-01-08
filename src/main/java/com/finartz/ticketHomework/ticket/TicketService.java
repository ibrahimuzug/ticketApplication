package com.finartz.ticketHomework.ticket;

import com.finartz.ticketHomework.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TicketService {
    Optional<Ticket> getTicketByTicketNumber(Integer ticketNumber);
}
