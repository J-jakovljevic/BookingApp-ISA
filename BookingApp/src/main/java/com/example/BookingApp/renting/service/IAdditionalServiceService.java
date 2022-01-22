package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.model.AdditionalService;
import net.bytebuddy.implementation.bytecode.Addition;

import java.util.List;

public interface IAdditionalServiceService {
    AdditionalService create(AdditionalServiceDTO dto);
    List<AdditionalService> getByRentingItem(Long rentingItemId);
    AdditionalService findById(Long id);
}
