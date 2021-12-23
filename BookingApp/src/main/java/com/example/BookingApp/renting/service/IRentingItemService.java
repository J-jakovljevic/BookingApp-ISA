package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.model.RentingItem;

public interface IRentingItemService {
    RentingItem findById(Long id);
}
