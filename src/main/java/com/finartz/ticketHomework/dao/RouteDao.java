package com.finartz.ticketHomework.dao;

import com.finartz.ticketHomework.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDao extends CrudRepository<Route, Integer> {
}
