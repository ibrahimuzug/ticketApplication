package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirlineDao extends CrudRepository<Airline, Integer> {
    Optional<Airline> findById(Integer id);

    void createAirline(Airline airline1);
}
