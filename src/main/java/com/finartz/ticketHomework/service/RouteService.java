package com.finartz.ticketHomework.service;

import com.finartz.ticketHomework.dto.RouteDto;

import java.util.Optional;

public interface RouteService {
    Optional<RouteDto> getRouteById(Integer id);

    void createRoute(RouteDto routeDto);
}
