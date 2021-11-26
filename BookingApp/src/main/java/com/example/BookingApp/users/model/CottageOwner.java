package com.example.BookingApp.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CottageOwner")
public class CottageOwner extends User{

}
