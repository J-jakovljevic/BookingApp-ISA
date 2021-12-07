package com.example.BookingApp.renting.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cottages")
public class Cottage extends RentingItem{
    private String rules;
    private int capacity;

    public Cottage() {
    }

    public Cottage(Long id, String name, String address, String description, String rules, int capacity) {
        super(id, name, address, description);
        this.rules = rules;
        this.capacity = capacity;
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
}
