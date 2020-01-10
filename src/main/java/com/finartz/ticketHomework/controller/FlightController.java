package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.FlightDto;
import com.finartz.ticketHomework.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<FlightDto> getFlightById(@PathVariable("id") Integer id) {
        return flightService.getFlightById(id);
    }

    @PostMapping("/create")
    public void createFlight(@RequestBody FlightDto flightDto) {
        flightService.createFlight(flightDto);
    }


}
