package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.reservations.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/actions")
public class ActionsController {
    private final IActionService  actionService;

    @Autowired
    public ActionsController(IActionService actionService) {
        this.actionService = actionService;
    }
}
