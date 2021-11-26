package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.mapper.CottageMapper;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.repository.CottageRepository;
import com.example.BookingApp.renting.service.ICottageService;
import com.example.BookingApp.users.mapper.AddressMapper;
import com.example.BookingApp.users.model.Address;
import com.example.BookingApp.users.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageServiceImpl implements ICottageService {
    private final CottageRepository cottageRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public CottageServiceImpl(CottageRepository cottageRepository, AddressRepository addressRepository) {
        this.cottageRepository = cottageRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Cottage addCottage(CottageDTO dto) {
        Address a = AddressMapper.MapDTOToAddress(dto.getAddress());
        addressRepository.save(a);
        Cottage c = CottageMapper.MapDTOToCottage(dto);
        c.setAddress(a);
        cottageRepository.save(c);
        return c;
    }

    @Override
    public List<CottageDTO> getAll() {
        return CottageMapper.MapToListDTO(cottageRepository.findAll());
    }
}
