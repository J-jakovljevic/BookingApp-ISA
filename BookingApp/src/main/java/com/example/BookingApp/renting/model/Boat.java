package com.example.BookingApp.renting.model;

import com.example.BookingApp.users.model.Address;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="boats")
public class Boat extends RentingItem{
    private String type;
    private Double length;
    private String engineNumber;
    private Double maxSpeed;
    private String navigationEquipment;
    private String additionalFishingEquipment;
    private String cancellationTerms;
    private String rules;
    private int capacity;

    public Boat() {
    }

    public Boat(Long id, String name, Address address, String description, String type, Double length, String engineNumber, Double maxSpeed, String navigationEquipment, String additionalFishingEquipment, String cancellationTerms, String rules, int capacity) {
        super(id, name, address, description);
        this.type = type;
        this.length = length;
        this.engineNumber = engineNumber;
        this.maxSpeed = maxSpeed;
        this.navigationEquipment = navigationEquipment;
        this.additionalFishingEquipment = additionalFishingEquipment;
        this.cancellationTerms = cancellationTerms;
        this.rules = rules;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getNavigationEquipment() {
        return navigationEquipment;
    }

    public void setNavigationEquipment(String navigationEquipment) {
        this.navigationEquipment = navigationEquipment;
    }

    public String getAdditionalFishingEquipment() {
        return additionalFishingEquipment;
    }

    public void setAdditionalFishingEquipment(String additionalFishingEquipment) {
        this.additionalFishingEquipment = additionalFishingEquipment;
    }

    public String getCancellationTerms() {
        return cancellationTerms;
    }

    public void setCancellationTerms(String cancellationTerms) {
        this.cancellationTerms = cancellationTerms;
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
