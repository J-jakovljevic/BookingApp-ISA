package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.mapper.FishingInstructorMapper;
import com.example.BookingApp.users.model.FishingInstructor;
import com.example.BookingApp.users.repository.FishingInstructorRepository;
import com.example.BookingApp.users.service.IFishingInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishingInstructorServiceImpl implements IFishingInstructorService {
    private final FishingInstructorRepository fishingInstructorRepository;



    @Autowired
    public FishingInstructorServiceImpl(FishingInstructorRepository fishingInstructorRepository) {
        this.fishingInstructorRepository = fishingInstructorRepository;
    }

    @Override
    public FishingInstructorDTO getById(long id) {
        return FishingInstructorMapper.MapToDTO(fishingInstructorRepository.getById(id));
    }

    @Override
    public FishingInstructorDTO add(FishingInstructorDTO dto) {
       /* Address a = AddressMapper.MapDTOToAddress(dto.getAddress());
        addressRepository.save(a);*/
        FishingInstructor fishingInstructor = FishingInstructorMapper.MapDTOToFishingInstructor(dto);
        fishingInstructor.setAddress(dto.getAddress());
        fishingInstructorRepository.save(fishingInstructor);
        return FishingInstructorMapper.MapToDTO(fishingInstructor);
    }

    @Override
    public List<FishingInstructorDTO> getAll() {
        return FishingInstructorMapper.MapToListDTOS(fishingInstructorRepository.findAll());
    }
}
