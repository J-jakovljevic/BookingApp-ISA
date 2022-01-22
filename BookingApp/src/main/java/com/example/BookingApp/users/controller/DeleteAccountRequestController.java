package com.example.BookingApp.users.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.SystemAdminAuthorization;
import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.dto.ComplaintDTO;
import com.example.BookingApp.users.dto.DeleteAccountRequestDTO;
import com.example.BookingApp.users.dto.DeleteAccountRequestReplyDTO;
import com.example.BookingApp.users.mapper.ComplaintMapper;
import com.example.BookingApp.users.mapper.DeleteAccountRequestMapper;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.model.DeleteAccountRequest;
import com.example.BookingApp.users.service.IDeleteAccountRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
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

    @SystemAdminAuthorization
    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<DeleteAccountRequestDTO> getAll() throws ParseException {
        return DeleteAccountRequestMapper.MapToListDTOS(deleteAccountRequestService.getAll());
    }

    @SystemAdminAuthorization
    @PostMapping(value = "/approve", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean approve(@RequestBody DeleteAccountRequestReplyDTO dto) throws ParseException {
        try {
            deleteAccountRequestService.approveRequest(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SystemAdminAuthorization
    @PostMapping(value = "/deny", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean deny(@RequestBody DeleteAccountRequestReplyDTO dto) throws ParseException {
        try {
            deleteAccountRequestService.denyRequest(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
