package com.example.BookingApp.reservations.dto;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.reservations.model.QuickReservation;
import java.util.Date;

public class ActionDTO {
    private Long id;
    private Long rentingItemId;
    private Date startTime;
    private Date endTime;
    private int capacity;
    private String additionalServices;
    private Double price;
    private boolean reserved;

    public ActionDTO() {}

    public ActionDTO(Long id, Long rentingItemId, Date startTime, Date endTime, int capacity, String additionalServices, Double price, boolean reserved) {
        this.id = id;
        this.rentingItemId = rentingItemId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.additionalServices = additionalServices;
        this.price = price;
        this.reserved = reserved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

     public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Long getRentingItemId() {
        return rentingItemId;
    }

    public void setRentingItemId(Long rentingItemId) {
        this.rentingItemId = rentingItemId;
    }
}
