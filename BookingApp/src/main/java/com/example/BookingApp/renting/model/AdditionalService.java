package com.example.BookingApp.renting.model;

import com.example.BookingApp.reservations.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="additional_services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private RentingItem rentingItem;
    private String description;
    @ManyToMany(mappedBy = "additionalServices")
    private List<Reservation> reservations;
}
