package com.example.BookingApp.renting.dto;
import com.example.BookingApp.users.dto.AddressDTO;
import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.model.Address;

public class FishingInstructorClassDTO {
    private Long id;
    private String name;
    private AddressDTO address;
    private String description;
    private String rules;
    private int capacity;
    private long fishingInstructorId;
    private String instructorBiography;

    public FishingInstructorClassDTO() {}

    public FishingInstructorClassDTO(Long id, String name, AddressDTO address, String description, String rules, int capacity, long fishingInstructorId, String instructorBiography) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.rules = rules;
        this.capacity = capacity;
        this.fishingInstructorId = fishingInstructorId;
        this.instructorBiography = instructorBiography;
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getFishingInstructorId() {
        return fishingInstructorId;
    }

    public void setFishingInstructorId(long fishingInstructorId) {
        this.fishingInstructorId = fishingInstructorId;
    }

    public String getInstructorBiography() {
        return instructorBiography;
    }

    public void setInstructorBiography(String instructorBiography) {
        this.instructorBiography = instructorBiography;
    }
}
