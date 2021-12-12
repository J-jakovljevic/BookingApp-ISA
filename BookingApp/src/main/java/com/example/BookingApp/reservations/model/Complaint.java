package com.example.BookingApp.reservations.model;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.users.model.Client;

import javax.persistence.*;

@Entity
@Table(name="complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    private Client client;
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    private RentingItem rentingItem;
    private String content;

    public Complaint() {}

    public Complaint(Long id, Client client, RentingItem rentingItem, String content) {
        this.id = id;
        this.client = client;
        this.rentingItem = rentingItem;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RentingItem getRentingItem() {
        return rentingItem;
    }

    public void setRentingItem(RentingItem rentingItem) {
        this.rentingItem = rentingItem;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
