package com.example.BookingApp.reservations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name="quickReservationPenalties")
public class QuickReservationPenalty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private QuickReservation quickReservation;
}
