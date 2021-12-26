package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.mapper.AdditionalServiceMapper;
import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.repository.AdditionalServiceRepository;
import com.example.BookingApp.renting.service.IAdditionalServiceService;
import com.example.BookingApp.renting.service.IRentingItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdditionalServiceServiceImpl implements IAdditionalServiceService {
    private final AdditionalServiceRepository additionalServiceRepository;
    private final IRentingItemService rentingItemService;
    @Override
    public AdditionalService create(AdditionalServiceDTO dto) {
        AdditionalService additionalService = AdditionalServiceMapper.MapDTOToAdditionalService(dto);
        additionalService.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        return additionalServiceRepository.save(additionalService);
    }

    @Override
    public List<AdditionalService> getByRentingItem(Long rentingItemId) {
        return additionalServiceRepository.findAllForRentingItem(rentingItemId);
    }

    @Override
    public AdditionalService findById(Long id) {
        return additionalServiceRepository.getById(id);
    }
}
