package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.users.dto.BoatOwnerDTO;
import com.example.BookingApp.users.mapper.BoatOwnerMapper;
import com.example.BookingApp.users.mapper.CottageOwnerMapper;
import com.example.BookingApp.users.model.BoatOwner;
import com.example.BookingApp.users.model.CottageOwner;
import com.example.BookingApp.users.repository.BoatOwnerRepository;
import com.example.BookingApp.users.service.IBoatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatOwnerServiceImpl implements IBoatOwnerService {
    private final BoatOwnerRepository boatOwnerRepository;

    @Autowired
    public BoatOwnerServiceImpl(BoatOwnerRepository boatOwnerRepository) {
        this.boatOwnerRepository = boatOwnerRepository;
    }

    @Override
    public void add(BoatOwnerDTO dto) {

    }

    @Override
    public List<BoatOwnerDTO> getAll() {
        List<BoatOwner> boatOwners = boatOwnerRepository.findAll();
        return BoatOwnerMapper.MapToListDTOS(boatOwners);
    }

    @Override
    public BoatOwnerDTO findById(long id) {
        return BoatOwnerMapper.MapToDTO(boatOwnerRepository.getById(id));
    }

    @Override
    public BoatOwnerDTO updateBoatOwner(BoatOwnerDTO dto) {
        BoatOwner b = boatOwnerRepository.getById(dto.getId());
        b.setSurname(dto.getSurname());
        b.setName(dto.getName());
        b.setPhoneNumber(dto.getPhoneNumber());
        b.setAddress(dto.getAddress());
        boatOwnerRepository.save(b);
        return BoatOwnerMapper.MapToDTO(b);
    }
}
