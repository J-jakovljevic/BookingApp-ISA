package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.mapper.CottageOwnerMapper;
import com.example.BookingApp.users.model.CottageOwner;
import com.example.BookingApp.users.repository.CottageOwnerRepository;
import com.example.BookingApp.users.service.ICottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageOwnerServiceImpl implements ICottageOwnerService {
    private final CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    private CottageOwnerServiceImpl(CottageOwnerRepository cottageOwnerRepository){
        this.cottageOwnerRepository = cottageOwnerRepository;
    }

    @Override
    public void add(CottageOwnerDTO dto) {
    }

    @Override
    public List<CottageOwnerDTO> getAll() {
        List<CottageOwner> cottageOwners = cottageOwnerRepository.findAll();
        return CottageOwnerMapper.MapToListDTOS(cottageOwners);
    }

    @Override
    public CottageOwnerDTO findById(long id) {
        return CottageOwnerMapper.MapToDTO(cottageOwnerRepository.getById(id));
    }

    @Override
    public CottageOwnerDTO updateCottageOwner(CottageOwnerDTO dto) {
        CottageOwner c = cottageOwnerRepository.getById(dto.getId());
        c.setSurname(dto.getSurname());
        c.setName(dto.getName());
        c.setPhoneNumber(dto.getPhoneNumber());
        c.setAddress(dto.getAddress());
        cottageOwnerRepository.save(c);
        return CottageOwnerMapper.MapToDTO(c);
    }

}
