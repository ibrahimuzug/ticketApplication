package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.TicketDto;

import java.util.Optional;


public interface TicketService {
    Optional<TicketDto> getTicketByTicketNumber(Integer ticketNumber);

    void createTicket(TicketDto ticketDto);

    void deleteTicket(Integer ticketNumber);

}
