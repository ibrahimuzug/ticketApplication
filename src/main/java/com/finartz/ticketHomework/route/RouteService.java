package com.finartz.ticketHomework.route;

import com.finartz.ticketHomework.entity.Route;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RouteService {
    Optional<Route> getRouteById(Integer id);
}
