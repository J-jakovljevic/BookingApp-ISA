package com.example.BookingApp.renting.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.renting.dto.SubscriptionDTO;
import com.example.BookingApp.renting.mapper.SubscriptionMapper;
import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.renting.service.ISubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/subscriptions")
public class SubscriptionController {
    private final ISubscriptionService subscriptionService;

    @ClientAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSubscription(@RequestBody SubscriptionDTO dto) throws ParseException {
        Subscription subscription;
        try {
            subscription = subscriptionService.createSubscription(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(subscription,HttpStatus.OK);
    }
    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody SubscriptionDTO getById(@RequestParam("id") Long id) throws ParseException {
        return SubscriptionMapper.MapToDTO(subscriptionService.findById(id));
    }

    @ClientAuthorization
    @GetMapping(value = "/getByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<SubscriptionDTO> getByClient(@RequestParam("id") Long id) throws ParseException {
        return SubscriptionMapper.MapToListDTO(subscriptionService.getByClient(id));
    }

    @ClientAuthorization
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Long> deletePost(@RequestParam Long id) {
        boolean isRemoved = subscriptionService.deleteSubscription(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
