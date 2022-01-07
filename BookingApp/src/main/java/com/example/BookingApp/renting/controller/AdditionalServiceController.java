package com.example.BookingApp.renting.controller;

import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.mapper.AdditionalServiceMapper;
import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.service.IAdditionalServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/additionalServices")
@RequiredArgsConstructor
public class AdditionalServiceController {
    private final IAdditionalServiceService additionalServiceService;

    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody AdditionalServiceDTO dto) throws ParseException {
        try {
            additionalServiceService.create(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAllByRentingItem", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<AdditionalServiceDTO> getAllByRentingItem(@RequestParam("rentingItemId") Long rentingItemId) throws ParseException {
        return AdditionalServiceMapper.MapToListDTO(additionalServiceService.getByRentingItem(rentingItemId));
    }
}
