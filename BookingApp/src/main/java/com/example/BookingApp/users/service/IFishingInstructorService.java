package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.repository.FishingInstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IFishingInstructorService {
    public FishingInstructorDTO getById(long id);
    public FishingInstructorDTO add(FishingInstructorDTO dto);
    public List<FishingInstructorDTO> getAll();

}
