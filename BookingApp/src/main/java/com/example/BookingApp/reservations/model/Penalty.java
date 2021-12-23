package com.example.BookingApp.reservations.model;

import com.example.BookingApp.users.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name="penalties")
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private QuickReservation quickReservation;
}
