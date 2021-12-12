package com.example.BookingApp.renting.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.renting.dto.RentingItemDTO;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.renting.service.IRentingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
@RequestMapping(value = "/rentingItems")
public class RentingItemController {
    private final IRentingItemService rentingItemService;

    @Autowired
    public RentingItemController(IRentingItemService rentingItemService) {
        this.rentingItemService = rentingItemService;
    }
}
