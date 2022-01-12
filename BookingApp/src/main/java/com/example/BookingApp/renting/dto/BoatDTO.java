package com.example.BookingApp.renting.dto;

import com.example.BookingApp.users.dto.AddressDTO;

public class BoatDTO extends RentingItemDTO{
    private String type;
    private Double length;
    private String engineNumber;
    private Double maxSpeed;
    private String navigationEquipment;
    private String additionalFishingEquipment;
    private String cancellationTerms;
    private String rules;

    public BoatDTO() {}

    public BoatDTO(Long id, String name, String address, String description, String type, Double length, String engineNumber, Double maxSpeed, String navigationEquipment, String cancellationTerms, String rules, int capacity) {
        super(id,name,address,description,capacity,"Boat");
        this.type = type;
        this.length = length;
        this.engineNumber = engineNumber;
        this.maxSpeed = maxSpeed;
        this.navigationEquipment = navigationEquipment;
        this.cancellationTerms = cancellationTerms;
        this.rules = rules;
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

}
