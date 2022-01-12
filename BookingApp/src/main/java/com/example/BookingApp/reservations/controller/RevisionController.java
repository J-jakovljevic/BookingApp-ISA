package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.dto.RevisionDTO;
import com.example.BookingApp.reservations.mapper.ReservationMapper;
import com.example.BookingApp.reservations.mapper.RevisionMapper;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.model.Revision;
import com.example.BookingApp.reservations.service.IRevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/revisions")
@RequiredArgsConstructor
public class RevisionController {
    private final IRevisionService revisionService;

    @ClientAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public RevisionDTO create(@RequestBody RevisionDTO dto) throws ParseException {
        Revision revision;
        try {
            revision = revisionService.create(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return RevisionMapper.MapToDTO(revision);
    }

}
