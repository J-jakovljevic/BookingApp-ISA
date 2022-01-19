package com.example.BookingApp.reservations.model;

import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.users.model.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="reservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private RentingItem rentingItem;
    private Date startTime;
    private Date endTime;
    private double price;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "reservation_additionalServices",
            joinColumns = { @JoinColumn(name = "reservation_id") },
            inverseJoinColumns = { @JoinColumn(name = "additional_service_id") }
    )
    private List<AdditionalService> additionalServices;
}
