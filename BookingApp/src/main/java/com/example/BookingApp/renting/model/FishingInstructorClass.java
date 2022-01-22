package com.example.BookingApp.renting.model;

import com.example.BookingApp.users.model.FishingInstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="fishingInstructorClasses")
@DiscriminatorValue(value = "FishingInstructorClass")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FishingInstructorClass extends RentingItem{
    private String rules;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private FishingInstructor fishingInstructor;
    private String instructorBiography;

   }
