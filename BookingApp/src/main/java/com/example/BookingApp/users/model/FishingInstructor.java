package com.example.BookingApp.users.model;

import com.example.BookingApp.renting.model.FishingInstructorClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "FishingInstructor")
public class FishingInstructor extends User{

    public FishingInstructor() {}

    public FishingInstructor(Long id, String name, String surname, Address address, String password, String phoneNumber, String email, String role) {
        super(id, name, surname, address, password, phoneNumber, email, role);
    }

}
