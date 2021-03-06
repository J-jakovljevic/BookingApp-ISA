package com.example.BookingApp.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ReservationPenaltyDTO {
    private Long id;
    private Long reservationId;
}
