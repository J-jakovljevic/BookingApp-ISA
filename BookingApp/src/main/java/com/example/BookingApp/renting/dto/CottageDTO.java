package com.example.BookingApp.renting.dto;

public class CottageDTO extends RentingItemDTO{
    private String rules;

    public CottageDTO() {}

    public CottageDTO(Long id, String name, String address, String description, String rules, int capacity) {
        super(id,name,address,description,capacity,"Cottage");
        this.rules = rules;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}
