package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDao extends CrudRepository<Airport, Integer> {
}
