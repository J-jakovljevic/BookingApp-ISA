package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.mapper.BoatMapper;
import com.example.BookingApp.renting.mapper.CottageMapper;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.repository.CottageRepository;
import com.example.BookingApp.renting.service.ICottageService;
import com.example.BookingApp.reservations.service.IRevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CottageServiceImpl implements ICottageService {
    private final CottageRepository cottageRepository;
    private final IRevisionService revisionService;


    @Override
    public Cottage addCottage(CottageDTO dto) {
        /*Address a = AddressMapper.MapDTOToAddress(dto.getAddress());
        addressRepository.save(a);*/
        Cottage c = CottageMapper.MapDTOToCottage(dto);
        c.setAddress(dto.getAddress());
        cottageRepository.save(c);
        return c;
    }

    @Override
    public List<CottageDTO> getAll() {
        List<CottageDTO> dtos = CottageMapper.MapToListDTO(cottageRepository.findAll());
        for(CottageDTO dto : dtos){
            dto.setAverageGrade(revisionService.countAverageGradeForRentingItem(dto.getId()));
        }
        return dtos;
    }

    @Override
    public List<CottageDTO> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<Cottage> allCottages = cottageRepository.findAll();
        List<CottageDTO> searchResults = new ArrayList<>();
        for (Cottage c : allCottages) {
            if (c.getName().toLowerCase().contains(searchInput)
                    || c.getDescription().toLowerCase().contains(searchInput)
                    || c.getAddress().toLowerCase().contains(searchInput) ) {
                searchResults.add(CottageMapper.MapToDTO(c));
            }
        }
        for(CottageDTO dto : searchResults){
            dto.setAverageGrade(revisionService.countAverageGradeForRentingItem(dto.getId()));
        }
        return searchResults;
    }

    @Override
    public List<CottageDTO> sortByNameAscending() {
        return CottageMapper.MapToListDTO(cottageRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
    }

    @Override
    public List<CottageDTO> sortByNameDescending() {
        return CottageMapper.MapToListDTO(cottageRepository.findAll(Sort.by(Sort.Direction.DESC, "name")));
    }

    @Override
    public List<CottageDTO> sortByLocationAscending() {
        return CottageMapper.MapToListDTO(cottageRepository.findAll(Sort.by(Sort.Direction.ASC, "address")));
    }

    @Override
    public List<CottageDTO> sortByLocationDescending() {
        return CottageMapper.MapToListDTO(cottageRepository.findAll(Sort.by(Sort.Direction.DESC, "address")));
    }

    @Override
    public CottageDTO getById(Long id) {
        CottageDTO dto = CottageMapper.MapToDTO(cottageRepository.getById(id));
        dto.setAverageGrade(revisionService.countAverageGradeForRentingItem(dto.getId()));
        return dto;
    }
}
