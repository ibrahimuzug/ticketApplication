package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineDao extends CrudRepository<Airline, Integer> {
}
