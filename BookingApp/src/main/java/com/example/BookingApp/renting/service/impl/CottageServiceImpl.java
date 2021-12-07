package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.mapper.CottageMapper;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.repository.CottageRepository;
import com.example.BookingApp.renting.service.ICottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CottageServiceImpl implements ICottageService {
    private final CottageRepository cottageRepository;

    @Autowired
    public CottageServiceImpl(CottageRepository cottageRepository) {
        this.cottageRepository = cottageRepository;
    }

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
        return CottageMapper.MapToListDTO(cottageRepository.findAll());
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
        return searchResults;
    }
}
