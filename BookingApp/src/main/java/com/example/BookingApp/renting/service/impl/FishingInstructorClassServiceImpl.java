package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.mapper.BoatMapper;
import com.example.BookingApp.renting.mapper.FishingInstructorClassMapper;
import com.example.BookingApp.renting.model.FishingInstructorClass;
import com.example.BookingApp.renting.repository.FishingInstructorClassRepository;
import com.example.BookingApp.renting.service.IFishingInstructorClassService;
import com.example.BookingApp.reservations.service.IRevisionService;
import com.example.BookingApp.users.mapper.FishingInstructorMapper;
import com.example.BookingApp.users.service.IFishingInstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FishingInstructorClassServiceImpl implements IFishingInstructorClassService {
    private final FishingInstructorClassRepository fishingInstructorClassRepository;
    public final IFishingInstructorService fishingInstructorService;
    private final IRevisionService revisionService;


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
        List<FishingInstructorClassDTO> dtos = FishingInstructorClassMapper.MapToListDTO(fishingInstructorClassRepository.findAll());
        for(FishingInstructorClassDTO dto : dtos){
            dto.setAverageGrade(revisionService.countAverageGradeForRentingItem(dto.getId()));
        }
        return dtos;
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
        for(FishingInstructorClassDTO dto : searchResults){
            dto.setAverageGrade(revisionService.countAverageGradeForRentingItem(dto.getId()));
        }
        return searchResults;
    }

    @Override
    public List<FishingInstructorClassDTO> sortByNameAscending() {
        return FishingInstructorClassMapper.MapToListDTO(fishingInstructorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
    }

    @Override
    public List<FishingInstructorClassDTO> sortByNameDescending() {
        return FishingInstructorClassMapper.MapToListDTO(fishingInstructorClassRepository.findAll(Sort.by(Sort.Direction.DESC, "name")));
    }

    @Override
    public List<FishingInstructorClassDTO> sortByLocationAscending() {
        return FishingInstructorClassMapper.MapToListDTO(fishingInstructorClassRepository.findAll(Sort.by(Sort.Direction.ASC, "address")));
    }

    @Override
    public List<FishingInstructorClassDTO> sortByLocationDescending() {
        return FishingInstructorClassMapper.MapToListDTO(fishingInstructorClassRepository.findAll(Sort.by(Sort.Direction.DESC, "address")));
    }

    @Override
    public FishingInstructorClassDTO getById(Long id) {
        FishingInstructorClassDTO dto = FishingInstructorClassMapper.MapToDTO(fishingInstructorClassRepository.getById(id));
        dto.setAverageGrade(revisionService.countAverageGradeForRentingItem(dto.getId()));
        return dto;
    }
}
