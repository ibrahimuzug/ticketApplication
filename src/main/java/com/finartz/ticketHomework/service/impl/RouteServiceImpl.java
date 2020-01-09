package com.finartz.ticketHomework.service.impl;

import com.finartz.ticketHomework.dao.RouteDao;
import com.finartz.ticketHomework.dto.AirlineDto;
import com.finartz.ticketHomework.dto.RouteDto;
import com.finartz.ticketHomework.entity.Airline;
import com.finartz.ticketHomework.entity.Route;
import com.finartz.ticketHomework.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteDao routeDao;

    @Override
    public Optional<RouteDto> getRouteById(Integer id) {
        Optional<Route> routeOptional = routeDao.findById(id);
        if (routeOptional.isPresent()) {
            Route route = routeOptional.get();
            RouteDto routeDto = new RouteDto();
            routeDto.setCode(route.getCode());
            routeDto.setFromAirportId(route.getFromAirportId());
            routeDto.setToAirportId(route.getToAirportId());
            return Optional.of(routeDto);
        }
        return null;
    }

    @Override
    public void createRoute(RouteDto routeDto) {
        Route route = new Route();
        route.setCode(routeDto.getCode());
        route.setFromAirportId(routeDto.getFromAirportId());
        route.setToAirportId(routeDto.getToAirportId());
        routeDao.save(route);
    }
}
