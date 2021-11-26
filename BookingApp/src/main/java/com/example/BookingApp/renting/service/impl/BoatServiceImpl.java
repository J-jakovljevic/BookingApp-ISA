package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.mapper.BoatMapper;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.renting.repository.BoatRepository;
import com.example.BookingApp.renting.service.IBoatService;
import com.example.BookingApp.users.mapper.AddressMapper;
import com.example.BookingApp.users.model.Address;
import com.example.BookingApp.users.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatServiceImpl implements IBoatService {
    private final BoatRepository boatRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public BoatServiceImpl(BoatRepository boatRepository, AddressRepository addressRepository) {
        this.boatRepository = boatRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Boat addBoat(BoatDTO dto) {
        Address address = AddressMapper.MapDTOToAddress(dto.getAddress());
        addressRepository.save(address);
        Boat newBoat = BoatMapper.MapDTOToBoat(dto);
        newBoat.setAddress(address);
        boatRepository.save(newBoat);
        return newBoat;

    }

    @Override
    public List<Boat> getAll() {
        return boatRepository.findAll();
    }
}
