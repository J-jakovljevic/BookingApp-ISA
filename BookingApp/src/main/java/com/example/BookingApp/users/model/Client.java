package com.example.BookingApp.users.model;

import com.example.BookingApp.users.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@DiscriminatorValue(value = "Client")
public class Client extends User {
    private String verificationCode;

    public Client() {
        this.setEnabled(false);
    }
}
