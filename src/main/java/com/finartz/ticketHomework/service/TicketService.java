package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.TicketDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TicketService {
    Optional<TicketDto> getTicketByTicketNumber(Integer ticketNumber);

    void createTicket(TicketDto ticketDto);

    void deleteTicket(Integer ticketNumber);

}
