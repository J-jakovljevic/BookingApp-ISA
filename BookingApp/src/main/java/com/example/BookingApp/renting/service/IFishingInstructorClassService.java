package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.model.FishingInstructorClass;

import java.util.List;

public interface IFishingInstructorClassService {
    FishingInstructorClass addFishingInstructorClass(FishingInstructorClassDTO dto);
    List<FishingInstructorClassDTO> getAll();
    List<FishingInstructorClassDTO> search(String searchInput);
    List<FishingInstructorClassDTO> sortByNameAscending();
    List<FishingInstructorClassDTO> sortByNameDescending();
    List<FishingInstructorClassDTO> sortByLocationAscending();
    List<FishingInstructorClassDTO> sortByLocationDescending();
    FishingInstructorClassDTO getById(Long id);
}
