package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.RentingItemAvailabilityDTO;
import com.example.BookingApp.reservations.dto.SearchReservationQueryDTO;
import com.example.BookingApp.reservations.model.RentingItemAvailability;

import java.util.List;

public interface IRentingItemAvailaibilityService {
    RentingItemAvailability create(RentingItemAvailabilityDTO dto);
    List<RentingItemAvailability> search(SearchReservationQueryDTO dto);
    List<RentingItemAvailability> removeReserved(List<RentingItemAvailability> rentingItemAvailabilities,SearchReservationQueryDTO dto);
}
