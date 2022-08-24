package com.example.BookingApp.renting.model;

import com.example.BookingApp.users.model.CottageOwner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="cottages")
@DiscriminatorValue(value = "Cottage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cottage extends RentingItem{
    private String rules;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    private CottageOwner cottageOwner;

   }
