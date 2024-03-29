package com.example.BookingApp.users.controller;

import com.example.BookingApp.autorizationAnnotations.BoatOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.mapper.ClientMapper;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    private final IClientService clientService;
    @Autowired
    ApplicationEventPublisher eventPublisher;
    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping(value = "/register", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerClient(@RequestBody ClientDTO dto) throws ParseException {
        try {
            clientService.registerClient(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTO> getAll() throws ParseException {
        return clientService.getAll();
    }

    @ClientAuthorization
    @CottageOwnerAuthorization
    @BoatOwnerAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO getById(@RequestParam("id") Long id) throws ParseException {
        return ClientMapper.MapToDTO(clientService.findById(id));
    }

    @ClientAuthorization
    @PutMapping(value = "/update", consumes =  MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO updateClient(@RequestBody ClientDTO dto) throws ParseException {
        ClientDTO clientDTO = new ClientDTO();
        try {
            clientDTO = clientService.updateClient(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientDTO;
    }


    @PutMapping(value = "/activateProfile", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO activateClient(@RequestParam("activationToken") String activationToken) throws ParseException {
        return ClientMapper.MapToDTO(clientService.activateClient(activationToken));
    }

}
