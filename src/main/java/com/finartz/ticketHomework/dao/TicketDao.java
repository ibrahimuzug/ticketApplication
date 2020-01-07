package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends CrudRepository<Ticket, Long> {
}
