package com.example.BookingApp.users.model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FishingInstructor")
public class FishingInstructor extends User{

    public FishingInstructor() {}



}
