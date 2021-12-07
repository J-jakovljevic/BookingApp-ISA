package com.example.BookingApp.users.model;

import com.example.BookingApp.users.model.enums.Role;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Client")
public class Client extends User {

    public Client() {}

}
