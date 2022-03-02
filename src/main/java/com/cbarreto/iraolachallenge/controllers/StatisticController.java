package com.cbarreto.iraolachallenge.controllers;

import com.cbarreto.iraolachallenge.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/estadisticas")
public class StatisticController {

    @Autowired
    PersonService personService;

    @GetMapping()
    public Map<String, Long> getValues() {
        return personService.getPersonStatistics();
    }

}
