package com.example.BookingApp.renting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cottages")
@DiscriminatorValue(value = "Cottage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cottage extends RentingItem{
    private String rules;
   }
