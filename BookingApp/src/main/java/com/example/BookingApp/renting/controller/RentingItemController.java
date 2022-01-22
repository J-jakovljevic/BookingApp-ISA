package com.example.BookingApp.renting.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.renting.dto.RentingItemDTO;
import com.example.BookingApp.renting.mapper.RentingItemMapper;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.reservations.service.IRevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/rentingItems")
public class RentingItemController {
    private final IRentingItemService rentingItemService;
    private final IRevisionService revisionService;

    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    RentingItemDTO getById(@RequestParam("id") Long id) throws ParseException {
        RentingItemDTO dto = RentingItemMapper.MapToDTO(rentingItemService.findById(id));
        dto.setAverageGrade(revisionService.countAverageGradeForRentingItem(dto.getId()));
        return dto;
    }

}
