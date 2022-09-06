package com.example.BookingApp.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("BoatOwner")
public class BoatOwner extends User{
    private String verificationCode;

    public BoatOwner() {

    }
}
