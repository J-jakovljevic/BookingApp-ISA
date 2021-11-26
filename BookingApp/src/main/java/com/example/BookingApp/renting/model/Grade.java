package com.example.BookingApp.renting.model;

import com.example.BookingApp.users.model.User;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int grade;
    @ManyToOne(fetch = FetchType.LAZY)
    private RentingItem rentingItem;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Grade() {}

    public Grade(Long id, int grade, RentingItem rentingItem, User user) {
        this.id = id;
        this.grade = grade;
        this.rentingItem = rentingItem;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public RentingItem getRentingItem() {
        return rentingItem;
    }

    public void setRentingItem(RentingItem rentingItem) {
        this.rentingItem = rentingItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
