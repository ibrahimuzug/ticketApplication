package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.FlightDto;
import com.finartz.ticketHomework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

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
