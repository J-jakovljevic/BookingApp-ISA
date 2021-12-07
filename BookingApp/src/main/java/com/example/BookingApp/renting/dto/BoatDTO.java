package com.example.BookingApp.renting.dto;

import com.example.BookingApp.users.dto.AddressDTO;

public class BoatDTO {
    private Long id;
    private String name;
    private String address;
    private String description;
    private String type;
    private Double length;
    private String engineNumber;
    private Double maxSpeed;
    private String navigationEquipment;
    private String additionalFishingEquipment;
    private String cancellationTerms;
    private String rules;
    private int capacity;

    public BoatDTO() {}

    public BoatDTO(Long id, String name, String address, String description, String type, Double length, String engineNumber, Double maxSpeed, String navigationEquipment, String additionalFishingEquipment, String cancellationTerms, String rules, int capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
