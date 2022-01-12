package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.mapper.ActionMapper;
import com.example.BookingApp.reservations.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/actions")
public class
ActionsController {
    private final IActionService  actionService;

    @Autowired
    public ActionsController(IActionService actionService) {
        this.actionService = actionService;
    }

    @ClientAuthorization
    @GetMapping(value = "/getByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ActionDTO> getByClient(@RequestParam("clientId") Long clientId) {
        return ActionMapper.MapToListDTO(actionService.getCurrentActionsForClient(clientId));
    }

}
