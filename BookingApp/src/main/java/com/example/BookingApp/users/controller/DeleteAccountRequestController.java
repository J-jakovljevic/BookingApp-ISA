package com.example.BookingApp.users.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.users.dto.ComplaintDTO;
import com.example.BookingApp.users.dto.DeleteAccountRequestDTO;
import com.example.BookingApp.users.service.IDeleteAccountRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/deleteAccountRequests")
public class DeleteAccountRequestController {
    private final IDeleteAccountRequestService deleteAccountRequestService;

    @ClientAuthorization
    @PostMapping(value = "/add", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addComplaint(@RequestBody DeleteAccountRequestDTO dto) throws ParseException {
        try {
            deleteAccountRequestService.createDeleteAccountRequest(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
