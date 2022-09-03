package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.BoatOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.SystemAdminAuthorization;
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
import java.util.List;

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

    @SystemAdminAuthorization
    @PostMapping(value = "/approveRevision", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean approveRevision(@RequestBody Long revisionId) throws ParseException {
        try {
            revisionService.approveRevision(revisionId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SystemAdminAuthorization
    @PostMapping(value = "/denyRevision", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean denyRevision(@RequestBody Long revisionId) throws ParseException {
        try {
            revisionService.deleteRevision(revisionId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SystemAdminAuthorization
    @GetMapping(value = "/getAllUnapprovedRevisions", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<RevisionDTO> getAllUnapprovedRevisions() throws ParseException {
        return RevisionMapper.MapToListDTO(revisionService.getAllUnapprovedRevisions());
    }

    @BoatOwnerAuthorization
    @CottageOwnerAuthorization
    @GetMapping(value = "/getRevisionForReservation", produces =  MediaType.APPLICATION_JSON_VALUE)
    public RevisionDTO getRevisionForReservation(@RequestBody Long reservationId) throws ParseException {
        return RevisionMapper.MapToDTO(revisionService.getRevisionForReservation(reservationId));
    }

}
