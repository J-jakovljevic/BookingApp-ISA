package com.example.BookingApp.renting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentingItemDTO {
    private Long id;
    private String name;
    private String address;
    private String description;
    private int capacity;

 }
