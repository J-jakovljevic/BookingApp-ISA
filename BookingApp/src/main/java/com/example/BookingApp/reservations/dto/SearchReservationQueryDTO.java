package com.example.BookingApp.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchReservationQueryDTO {
    private Date startDate;
    private Date endDate;
    private String rentingItemType;
    private int capacity;
    private double grade;
    private String location;

}
