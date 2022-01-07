package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.reservations.dto.RentingItemAvailabilityDTO;
import com.example.BookingApp.reservations.dto.SearchReservationQueryDTO;
import com.example.BookingApp.reservations.mapper.RentingItemAvailabilityMapper;
import com.example.BookingApp.reservations.model.RentingItemAvailability;
import com.example.BookingApp.reservations.repository.RentingItemAvailabilityRepository;
import com.example.BookingApp.reservations.service.IRentingItemAvailaibilityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentingItemAvailabilityServiceImpl implements IRentingItemAvailaibilityService {
    private final RentingItemAvailabilityRepository rentingItemAvailabilityRepository;
    private final ModelMapper mapper;
    private final IRentingItemService rentingItemService;
    @Override
    public RentingItemAvailability create(RentingItemAvailabilityDTO dto) {
        RentingItemAvailability rentingItemAvailability = RentingItemAvailabilityMapper.MapDTOToRentingItemAvailability(dto);
        rentingItemAvailability.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
      return rentingItemAvailabilityRepository.save(rentingItemAvailability);
    }

    @Override
    public List<RentingItemAvailability> search(SearchReservationQueryDTO dto) {
        return rentingItemAvailabilityRepository.searchByParameters(dto.getStartDate(),dto.getEndDate(),dto.getCapacity(),dto.getRentingItemType());
    }
}
