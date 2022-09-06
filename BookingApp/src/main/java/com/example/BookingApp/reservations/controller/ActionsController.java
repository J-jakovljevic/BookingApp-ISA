package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.BoatOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.mapper.ActionMapper;
import com.example.BookingApp.reservations.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ActionDTO getActionById(@RequestParam("id") Long id) {
        return ActionMapper.MapToDTO(actionService.getActionById(id));
    }

    @BoatOwnerAuthorization
    @GetMapping(value = "/getByBoatOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ActionDTO> getByBoatOwner(@RequestParam("ownerId") Long ownerId) {
        return ActionMapper.MapToListDTO(actionService.getCurrentActionsForBoatOwner(ownerId));
    }

    @CottageOwnerAuthorization
    @GetMapping(value = "/getByCottageOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ActionDTO> getByCottageOwner(@RequestParam("ownerId") Long ownerId) {
        return ActionMapper.MapToListDTO(actionService.getCurrentActionsForCottageOwner(ownerId));
    }

    @BoatOwnerAuthorization
    @CottageOwnerAuthorization
    @PostMapping(value = "/create", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAction(@RequestBody ActionDTO dto) throws ParseException {
        try {
         ActionMapper.MapToDTO(actionService.createAction(dto));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
