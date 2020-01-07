package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightDao extends CrudRepository<Flight, Long> {
}
