package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.mapper.BoatMapper;
import com.example.BookingApp.renting.mapper.CottageMapper;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.repository.BoatRepository;
import com.example.BookingApp.renting.service.IBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class BoatServiceImpl implements IBoatService {
    private final BoatRepository boatRepository;
    @Autowired
    public BoatServiceImpl(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    @Override
    public Boat addBoat(BoatDTO dto) {
       // Address address = AddressMapper.MapDTOToAddress(dto.getAddress());
       // addressRepository.save(address);
        Boat newBoat = BoatMapper.MapDTOToBoat(dto);
       // newBoat.setAddress(address);
        boatRepository.save(newBoat);
        return newBoat;

    }

    @Override
    public List<BoatDTO> getAll() {
        return BoatMapper.MapToListDTO(boatRepository.findAll());
    }

    @Override
    public List<BoatDTO> search(String searchInput) {
        searchInput = searchInput.toLowerCase();
        List<Boat> allBoats = boatRepository.findAll();
        List<BoatDTO> searchResults = new ArrayList<>();
        for (Boat b : allBoats) {
            if (b.getName().toLowerCase().contains(searchInput)
                    || b.getDescription().toLowerCase().contains(searchInput)
                    || b.getAddress().toLowerCase().contains(searchInput)
                    || b.getEngineNumber().toLowerCase().contains(searchInput)
                    || b.getNavigationEquipment().toLowerCase().contains(searchInput)) {
                searchResults.add(BoatMapper.MapToDTO(b));
            }
        }
        return searchResults;
    }
}
