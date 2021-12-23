package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.renting.repository.RentingItemRepository;
import com.example.BookingApp.renting.service.IRentingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentingItemService implements IRentingItemService {
    private final RentingItemRepository rentingItemRepository;

    @Autowired
    public RentingItemService(RentingItemRepository rentingItemRepository) {
        this.rentingItemRepository = rentingItemRepository;
    }

    @Override
    public RentingItem findById(Long id) {
        return rentingItemRepository.getById(id);
    }
}
