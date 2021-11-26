package com.example.BookingApp.users.model;

import com.example.BookingApp.users.model.enums.Role;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Client")
public class Client extends User {

    public Client() {}

    public Client(Long id, String name, String surname, Address address, String password, String phoneNumber, String email, String role) {
        super(id, name, surname, address, password, phoneNumber, email, role);
    }
}
