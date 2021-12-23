package com.example.BookingApp.reservations.dto;

import com.example.BookingApp.reservations.model.QuickReservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PenaltyDTO {
    private Long id;
    private Long quickReservationId;
}
