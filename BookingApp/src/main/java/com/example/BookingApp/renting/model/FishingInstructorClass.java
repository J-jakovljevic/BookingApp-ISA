package com.example.BookingApp.renting.model;

import com.example.BookingApp.users.model.Address;
import com.example.BookingApp.users.model.FishingInstructor;

import javax.persistence.*;

@Entity
@Table(name="fishingInstructorClasses")
public class FishingInstructorClass extends RentingItem{
    private String rules;
    private int capacity;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private FishingInstructor fishingInstructor;
    private String instructorBiography;

    public FishingInstructorClass() {
    }

    public FishingInstructorClass(Long id, String name, Address address, String description, String rules, int capacity, FishingInstructor fishingInstructor, String instructorBiography) {
        super(id, name, address, description);
        this.rules = rules;
        this.capacity = capacity;
        this.fishingInstructor = fishingInstructor;
        this.instructorBiography =instructorBiography;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public FishingInstructor getFishingInstructor() {
        return fishingInstructor;
    }

    public void setFishingInstructor(FishingInstructor fishingInstructor) {
        this.fishingInstructor = fishingInstructor;
    }

    public String getInstructorBiography() {
        return instructorBiography;
    }

    public void setInstructorBiography(String instructorBiography) {
        this.instructorBiography = instructorBiography;
    }
}
