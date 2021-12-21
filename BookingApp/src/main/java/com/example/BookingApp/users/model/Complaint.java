package com.example.BookingApp.users.model;

import com.example.BookingApp.renting.model.RentingItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Client sender;
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private RentingItem rentingItem;
}
