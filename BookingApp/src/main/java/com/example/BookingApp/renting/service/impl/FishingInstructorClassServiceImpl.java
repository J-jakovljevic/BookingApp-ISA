package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.mapper.FishingInstructorClassMapper;
import com.example.BookingApp.renting.model.FishingInstructorClass;
import com.example.BookingApp.renting.repository.FishingInstructorClassRepository;
import com.example.BookingApp.renting.service.IFishingInstructorClassService;
import com.example.BookingApp.users.mapper.FishingInstructorMapper;
import com.example.BookingApp.users.service.IFishingInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FishingInstructorClassServiceImpl implements IFishingInstructorClassService {
    private final FishingInstructorClassRepository fishingInstructorClassRepository;
    public final IFishingInstructorService fishingInstructorService;
    @Autowired
    public FishingInstructorClassServiceImpl(FishingInstructorClassRepository fishingInstructorClassRepository, IFishingInstructorService fishingInstructorService) {
        this.fishingInstructorClassRepository = fishingInstructorClassRepository;
        this.fishingInstructorService = fishingInstructorService;
    }

    @Override
    public FishingInstructorClass addFishingInstructorClass(FishingInstructorClassDTO dto) {
      //  Address a = AddressMapper.MapDTOToAddress(dto.getAddress());
       // addressRepository.save(a);
        FishingInstructorClass f = FishingInstructorClassMapper.MapDTOToFishingInstructorClass(dto);
       // f.setAddress(a);
        f.setFishingInstructor(FishingInstructorMapper.MapDTOToFishingInstructor(fishingInstructorService.getById(dto.getFishingInstructorId())));
        fishingInstructorClassRepository.save(f);
        return f;

    }

    @Override
    public List<FishingInstructorClassDTO> getAll() {
        return FishingInstructorClassMapper.MapToListDTO(fishingInstructorClassRepository.findAll());
    }

    @Override
    public List<FishingInstructorClassDTO> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<FishingInstructorClass> allFishingInstructorClasses = fishingInstructorClassRepository.findAll();
        List<FishingInstructorClassDTO> searchResults = new ArrayList<>();
        for (FishingInstructorClass f : allFishingInstructorClasses) {
            if (f.getName().toLowerCase().contains(searchInput)
                    || f.getDescription().toLowerCase().contains(searchInput)
                    || f.getInstructorBiography().toLowerCase().contains(searchInput)
                    || f.getAddress().toLowerCase().contains(searchInput)
                    || f.getFishingInstructor().getName().toLowerCase().contains(searchInput)
                    || f.getFishingInstructor().getSurname().toLowerCase().contains(searchInput)) {
                searchResults.add(FishingInstructorClassMapper.MapToDTO(f));
            }
        }
        return searchResults;
    }
}
