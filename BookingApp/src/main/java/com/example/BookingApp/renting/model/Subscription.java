package com.example.BookingApp.renting.model;

import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
    private RentingItem rentingItem;

}
