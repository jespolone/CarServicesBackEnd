package com.jespApiTest.CarServices.controller;
import com.jespApiTest.CarServices.models.DateModel;
import com.jespApiTest.CarServices.services.DateModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



/**
 *
 * Model
 *
 * @author Elvin Iluca
 *
 */
@Slf4j
@RestController
public class DateModelController {

    @Autowired
    private DateModelService dateModelService;

    @GetMapping("userdate{id}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<DateModel> getUserDate(@PathVariable("id") int userId){
        return dateModelService.getUserDate(userId);
    }

    @PostMapping("date/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDate(@RequestBody DateModel date) {
        log.info(date.toString());
        dateModelService.createDate(date);
    }

//    @GetMapping("date/all")
//    @ResponseStatus(HttpStatus.OK)
//    public Iterable<DateModel> getListDate() {
//        return dateModelService.getListDate();
//    }
//
//    @PostMapping("date/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createDate(@RequestBody DateModel date) {
//
//        dateModelService.createDate(date);
//    }
//
//    @GetMapping("date/{date}")
//    @ResponseStatus(HttpStatus.OK)
//    public Iterable<DateModel> getTodayListDate(@PathVariable("date") String stringDate){
//        return dateModelService.getTodayListDate(stringDate);
//    }

}
