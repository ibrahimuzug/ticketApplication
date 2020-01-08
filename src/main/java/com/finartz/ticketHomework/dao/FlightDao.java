package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends CrudRepository<Flight, Integer> {
}
