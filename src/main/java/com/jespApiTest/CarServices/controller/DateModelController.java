package com.jespApiTest.CarServices.controller;

import com.jespApiTest.CarServices.models.Auto;
import com.jespApiTest.CarServices.models.DateModel;
import com.jespApiTest.CarServices.services.DateModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 *
 * Model
 *
 * @author Elvin Iluca
 *
 */

@RestController
public class DateModelController {

    @Autowired
    private DateModelService dateModelService;

    @GetMapping("date/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<DateModel> getListDate() {

        return dateModelService.getListDate();
    }

    @PostMapping("date/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDate(@RequestBody DateModel date) {

        dateModelService.createDate(date);
    }

    @GetMapping("date/{date}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<DateModel> getTodayListDate(@PathVariable("date") String stringDate){
        return dateModelService.getTodayListDate(stringDate);
    }

}
