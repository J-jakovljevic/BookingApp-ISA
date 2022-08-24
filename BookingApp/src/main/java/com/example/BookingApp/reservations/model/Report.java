package com.example.BookingApp.reservations.model;

import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.model.CottageOwner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="reports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    private Long clientId;
    private Long reservationId;
    private Long CottageOwnerId;
    private double grade;
    private String description;
    private boolean approved;
}
