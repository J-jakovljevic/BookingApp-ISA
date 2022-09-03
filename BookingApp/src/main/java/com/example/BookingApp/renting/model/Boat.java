package com.example.BookingApp.renting.model;

import com.example.BookingApp.users.model.BoatOwner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "boats")
@DiscriminatorValue(value = "Boat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boat extends RentingItem{
    private String boatType;
    private Double length;
    private String engineNumber;
    private Double maxSpeed;
    private String navigationEquipment;
    private String cancellationTerms;
    private String rules;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    private BoatOwner boatOwner;

   }
