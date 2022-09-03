package com.example.BookingApp.reservations.model;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.users.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="revisions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private RentingItem rentingItem;
    private double grade;
    private String description;
    private boolean approved;
    private Long reservationId;
}
