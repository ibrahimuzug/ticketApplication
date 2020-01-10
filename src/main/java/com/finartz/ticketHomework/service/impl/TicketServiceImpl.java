package com.finartz.ticketHomework.service.impl;

import com.finartz.ticketHomework.dao.FlightDao;
import com.finartz.ticketHomework.dao.TicketDao;
import com.finartz.ticketHomework.dto.TicketDto;
import com.finartz.ticketHomework.entity.Flight;
import com.finartz.ticketHomework.entity.Ticket;
import com.finartz.ticketHomework.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;
    private final FlightDao flightDao;

    public TicketServiceImpl(TicketDao ticketDao, FlightDao flightDao) {
        this.ticketDao = ticketDao;
        this.flightDao = flightDao;
    }

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
        Integer countTicketByFlight = ticketDao.countTicketByFlight(ticketDto.getFlightId());
        Optional<Flight> flight = flightDao.findById(ticketDto.getFlightId());
        Double flightBasePrice = flight.get().getPrice();
        Integer quota = flight.get().getQuota();

        int newTicketNumber = (countTicketByFlight + 1);
        int factor = findNewTicketPercentage(quota, newTicketNumber);
        Double calculatedPrice = calculateTicketPrice(flightBasePrice, factor);

        Ticket ticket = new Ticket();
        ticket.setTicketNumber(ticketDto.getTicketNumber());
        ticket.setFlightId(ticketDto.getFlightId());
        ticket.setDate(ticketDto.getDate());
        ticket.setTime(ticketDto.getTime());
        ticket.setPrice(calculatedPrice);
        ticketDao.save(ticket);
    }

    private int findNewTicketPercentage(Integer quota, int newTicketNumber) {
        for (int i = 1; i <= 10; i++) {
            int quotaRate = quota * (i * 10) / 100;
            if (newTicketNumber <= quotaRate)
                return i;
        }
        return 0;
    }

    private Double calculateTicketPrice(Double ticketPrice, Integer factor) {
        if (factor <= 0)
            return ticketPrice;

        for (int i = 0; i < factor; i++) {
            ticketPrice = ticketPrice + (ticketPrice * 0.1);
        }
        return ticketPrice;
    }

    @Override
    public void deleteTicket(Integer ticketNumber) {
        Optional<Ticket> ticketOptional = ticketDao.findById(ticketNumber);
        deleteTicket(ticketNumber);
    }

}
