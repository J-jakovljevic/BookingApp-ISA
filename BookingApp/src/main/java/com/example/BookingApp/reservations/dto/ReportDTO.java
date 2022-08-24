package com.example.BookingApp.reservations.dto;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.model.Client;
//import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.model.CottageOwner;
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

public class ReportDTO {
    private Long id;
    private Long clientId;
    private Long reservationId;
    private Long CottageOwnerId;
    private double grade;
    private String description;
}
