package com.example.BookingApp.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue(value = "CottageOwner")
public class CottageOwner extends User{
    private String verificationCode;

    public CottageOwner() {

    }
}
