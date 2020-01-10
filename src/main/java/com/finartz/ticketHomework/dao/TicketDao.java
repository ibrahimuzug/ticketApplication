package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer> {

    @Query("select count(id) from Ticket t where t.flightId=:flightId")
    Integer countTicketByFlight(@Param("flightId") Integer flightId);
}
