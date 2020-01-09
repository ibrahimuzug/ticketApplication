package com.finartz.ticketHomework.controller;

import com.finartz.ticketHomework.dto.AirlineDto;
import com.finartz.ticketHomework.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<AirlineDto> getAirlineById(@PathVariable("id") Integer id) {
        return airlineService.getAirlineById(id);
    }

    @PostMapping("/create")
    public void createAirline(@RequestBody AirlineDto airlineDto) {
        airlineService.createAirline(airlineDto);
    }


}
