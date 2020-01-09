package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.RouteDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RouteService {
    Optional<RouteDto> getRouteById(Integer id);

    void createRoute(RouteDto routeDto);
}
