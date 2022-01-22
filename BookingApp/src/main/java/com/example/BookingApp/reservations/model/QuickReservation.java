package com.example.BookingApp.reservations.model;

import com.example.BookingApp.users.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="quickReservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuickReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Client client;
    @OneToOne(cascade = CascadeType.DETACH)
    private Action action;
    private boolean cancelled;
}
