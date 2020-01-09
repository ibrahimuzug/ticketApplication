package com.finartz.ticketHomework.service.impl;

import com.finartz.ticketHomework.dao.TicketDao;
import com.finartz.ticketHomework.dto.AirlineDto;
import com.finartz.ticketHomework.dto.TicketDto;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.entity.Ticket;
import com.finartz.ticketHomework.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDao ticketDao;

    @Override
    public Optional<TicketDto> getTicketByTicketNumber(Integer ticketNumber) {
        Optional<Ticket> ticketOptional = ticketDao.findById(ticketNumber);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            TicketDto ticketDto = new TicketDto();
            ticketDto.setTicketNumber(ticket.getTicketNumber());
            ticketDto.setFlightId(ticket.getFlightId());
            ticketDto.setDate(ticket.getDate());
            ticketDto.setPrice(ticket.getPrice());
            return Optional.of(ticketDto);
        }
        return null;
    }

    @Override
    public void createTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(ticketDto.getTicketNumber());
        ticket.setFlightId(ticketDto.getFlightId());
        ticket.setDate(ticketDto.getDate());
        ticket.setTime(ticketDto.getTime());
        ticket.setPrice(ticketDto.getPrice());
        ticketDao.save(ticket);
    }

    @Override
    public void deleteTicket(Integer ticketNumber) {

    }

}
