package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.mapper.CottageMapper;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.mapper.FishingInstructorMapper;
import com.example.BookingApp.users.model.FishingInstructor;
import com.example.BookingApp.users.repository.FishingInstructorRepository;
import com.example.BookingApp.users.service.IFishingInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<FishingInstructorDTO> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<FishingInstructor> allFishingInstructors = fishingInstructorRepository.findAll();
        List<FishingInstructorDTO> searchResults = new ArrayList<>();
        for (FishingInstructor f : allFishingInstructors) {
            if (f.getName().toLowerCase().contains(searchInput)
                    || f.getSurname().toLowerCase().contains(searchInput)
                    || f.getEmail().toLowerCase().contains(searchInput)
                    || f.getAddress().toLowerCase().contains(searchInput) ) {
                searchResults.add(FishingInstructorMapper.MapToDTO(f));
            }
        }
        return searchResults;
    }
}
