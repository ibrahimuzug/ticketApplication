package com.finartz.ticketHomework.ticket;

import com.finartz.ticketHomework.dao.TicketDao;
import com.finartz.ticketHomework.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDao ticketDao;

    @Override
    public Optional<Ticket> getTicketByTicketNumber(Integer ticketNumber) {
        return ticketDao.findById(ticketNumber);
    }
}
