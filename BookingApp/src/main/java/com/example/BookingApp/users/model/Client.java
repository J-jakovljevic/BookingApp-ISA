package com.example.BookingApp.users.model;

import com.example.BookingApp.users.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@DiscriminatorValue(value = "Client")
public class Client extends User {

    public Client() {}

}
