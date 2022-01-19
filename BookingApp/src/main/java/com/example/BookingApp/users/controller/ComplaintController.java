package com.example.BookingApp.users.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.SystemAdminAuthorization;
import com.example.BookingApp.users.dto.ComplaintDTO;
import com.example.BookingApp.users.dto.ComplaintReplyDTO;
import com.example.BookingApp.users.dto.DeleteAccountRequestReplyDTO;
import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.mapper.ComplaintMapper;
import com.example.BookingApp.users.service.IComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/complaints")
public class ComplaintController {
    private final IComplaintService complaintService;

    @ClientAuthorization
    @PostMapping(value = "/add", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addComplaint(@RequestBody ComplaintDTO dto) throws ParseException {
        try {
            complaintService.createComplaint(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ClientAuthorization
    @PostMapping(value = "/addReply", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addComplaintReply(@RequestBody ComplaintReplyDTO dto) throws ParseException {
        try {
            complaintService.createComplaintReply(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ComplaintDTO> getAll() throws ParseException {
        return ComplaintMapper.MapToListDTOS(complaintService.getAll());
    }

}
