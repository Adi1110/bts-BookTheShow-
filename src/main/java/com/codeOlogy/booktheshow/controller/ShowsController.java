package com.codeOlogy.booktheshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeOlogy.booktheshow.entity.Shows;
import com.codeOlogy.booktheshow.exceptionHandler.SeatNotFoundException;
import com.codeOlogy.booktheshow.exceptionHandler.ShowNotFoundException;
import com.codeOlogy.booktheshow.services.ShowsService;

@RestController
public class ShowsController {

    @Autowired
    private ShowsService showService;

    @GetMapping("/shows/{showId}")
    public Shows getShowDetails(@PathVariable Long showId, @RequestParam List<String> listOfSeats)
            throws ShowNotFoundException, SeatNotFoundException {
        return showService.getShowDetails(showId, listOfSeats);
    }
}
