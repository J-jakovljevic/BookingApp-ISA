package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.model.FishingInstructorClass;

import java.util.List;

public interface IFishingInstructorClassService {
    FishingInstructorClass addFishingInstructorClass(FishingInstructorClassDTO dto);
    List<FishingInstructorClassDTO> getAll();
}
