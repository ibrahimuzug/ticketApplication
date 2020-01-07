package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Airline;
import org.springframework.data.repository.CrudRepository;

public interface AirlineDao extends CrudRepository<Airline, Long> {
}
