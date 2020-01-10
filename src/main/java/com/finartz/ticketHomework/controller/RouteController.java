package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.RouteDto;
import com.finartz.ticketHomework.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<RouteDto> getRouteById(@PathVariable("id") Integer id) {
        return routeService.getRouteById(id);
    }

    @PostMapping("/create")
    public void createRoute(@RequestBody RouteDto routeDto) {
        routeService.createRoute(routeDto);
    }
}
