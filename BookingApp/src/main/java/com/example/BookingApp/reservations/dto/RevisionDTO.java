package com.example.BookingApp.reservations.dto;

import com.example.BookingApp.renting.dto.RentingItemDTO;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RevisionDTO {
    private Long id;
    private Long clientId;
    private Long rentingItemId;
    private double grade;
    private String description;
}
