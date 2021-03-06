package com.example.BookingApp.users.dto;

public class FishingInstructorDTO {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String password;
    private String phoneNumber;
    private String email;
    private String role;

    public FishingInstructorDTO() {}

    public FishingInstructorDTO(Long id, String name, String surname, String address, String password, String phoneNumber, String email, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
