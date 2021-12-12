package com.example.BookingApp.reservations.model;

import com.example.BookingApp.renting.model.RentingItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name="actions")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private RentingItem rentingItem;
    private Date startTime;
    private Date endTime;
    private int capacity;
    private String additionalServices;
    private Double price;
    private boolean reserved;

    public Action() {}

    public Action(Long id, RentingItem rentingItem, Date startTime, Date endTime, int capacity, String additionalServices, Double price,  boolean reserved) {
        this.id = id;
        this.rentingItem = rentingItem;
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

    public RentingItem getRentingItem() {
        return rentingItem;
    }

    public void setRentingItem(RentingItem rentingItem) {
        this.rentingItem = rentingItem;
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
}
