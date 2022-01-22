package com.example.BookingApp.renting.dto;

import com.example.BookingApp.renting.model.RentingItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalServiceDTO {
    private Long id;
    private Long rentingItemId;
    private String description;
}
