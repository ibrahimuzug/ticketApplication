package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportDao extends CrudRepository<Airport, Long> {
}
