package com.example.BookingApp.reservations.dto;

import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.dto.RentingItemDTO;
import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.users.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Long id;
    private Long clientId;
    private RentingItemDTO rentingItem;
    private Date startTime;
    private Date endTime;
    private double price;
    private List<AdditionalServiceDTO> additionalServices;
    private Long rentingItemId;
}

