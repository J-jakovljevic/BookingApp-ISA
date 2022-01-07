package com.example.BookingApp.reservations.dto;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.reservations.model.QuickReservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionDTO {
    private Long id;
    private Long rentingItemId;
    private Date startTime;
    private Date endTime;
    private Double price;
    private boolean reserved;

   }
