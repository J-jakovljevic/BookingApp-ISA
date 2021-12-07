package com.example.BookingApp.users.service;

import com.example.BookingApp.users.model.Authority;

import java.util.List;

public interface IAuthorityService {
    List<Authority> findById(Long id);
    List<Authority> findByName(String name);
}