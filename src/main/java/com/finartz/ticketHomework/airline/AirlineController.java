package com.finartz.ticketHomework.airline;

import com.finartz.ticketHomework.entity.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Airline> getAirportById(@PathVariable("id") Integer id) {
        return airlineService.getAirlineById(id);
    }


}
