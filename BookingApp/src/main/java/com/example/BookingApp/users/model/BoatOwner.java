package com.example.BookingApp.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BoatOwner")
public class BoatOwner extends User{

}
