package com.example.BookingApp.renting.dto;

public class FishingInstructorClassDTO extends RentingItemDTO{
    private String rules;
    private int capacity;
    private long fishingInstructorId;
    private String instructorBiography;

    public FishingInstructorClassDTO() {}

    public FishingInstructorClassDTO(Long id, String name, String address, String description, String rules, int capacity, long fishingInstructorId, String instructorBiography) {
        super(id,name,address,description,capacity,"FishingInstructorClass",0);
        this.rules = rules;
        this.fishingInstructorId = fishingInstructorId;
        this.instructorBiography = instructorBiography;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
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
}
