package com.example.BookingApp.renting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

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

   }
