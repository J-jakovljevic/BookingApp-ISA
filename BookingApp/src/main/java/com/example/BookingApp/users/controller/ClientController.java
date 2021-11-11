package com.example.BookingApp.users.controller;

import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.service.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@CrossOrigin
@RequestMapping(value = "/client")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/register", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerClient(@RequestBody Client client) throws ParseException {
        try {
             clientService.registerClient(client);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
