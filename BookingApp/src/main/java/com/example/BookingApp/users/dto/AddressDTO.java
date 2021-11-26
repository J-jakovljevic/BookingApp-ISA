package com.example.BookingApp.users.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private Double latitude;
    private Double longitude;
    private String state;
    public AddressDTO() {}

    public AddressDTO(Long id, String street, String city, Double latitude, Double longitude, String state) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
