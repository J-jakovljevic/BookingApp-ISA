package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.mapper.FishingInstructorClassMapper;
import com.example.BookingApp.renting.model.FishingInstructorClass;
import com.example.BookingApp.renting.repository.FishingInstructorClassRepository;
import com.example.BookingApp.renting.service.IFishingInstructorClassService;
import com.example.BookingApp.users.mapper.AddressMapper;
import com.example.BookingApp.users.mapper.FishingInstructorMapper;
import com.example.BookingApp.users.model.Address;
import com.example.BookingApp.users.repository.AddressRepository;
import com.example.BookingApp.users.service.IFishingInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishingInstructorClassServiceImpl implements IFishingInstructorClassService {
    private final FishingInstructorClassRepository fishingInstructorClassRepository;
    private final AddressRepository addressRepository;
    public final IFishingInstructorService fishingInstructorService;
    @Autowired
    public FishingInstructorClassServiceImpl(FishingInstructorClassRepository fishingInstructorClassRepository, AddressRepository addressRepository, IFishingInstructorService fishingInstructorService) {
        this.fishingInstructorClassRepository = fishingInstructorClassRepository;
        this.addressRepository = addressRepository;
        this.fishingInstructorService = fishingInstructorService;
    }

    @Override
    public FishingInstructorClass addFishingInstructorClass(FishingInstructorClassDTO dto) {
        Address a = AddressMapper.MapDTOToAddress(dto.getAddress());
        addressRepository.save(a);
        FishingInstructorClass f = FishingInstructorClassMapper.MapDTOToFishingInstructorClass(dto);
        f.setAddress(a);
        f.setFishingInstructor(FishingInstructorMapper.MapDTOToFishingInstructor(fishingInstructorService.getById(dto.getFishingInstructorId())));
        fishingInstructorClassRepository.save(f);
        return f;

    }

    @Override
    public List<FishingInstructorClassDTO> getAll() {
        return FishingInstructorClassMapper.MapToListDTO(fishingInstructorClassRepository.findAll());
    }
}
