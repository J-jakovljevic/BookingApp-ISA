package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.users.dto.BoatOwnerDTO;
import com.example.BookingApp.users.mapper.BoatOwnerMapper;
import com.example.BookingApp.users.model.Authority;
import com.example.BookingApp.users.model.BoatOwner;
import com.example.BookingApp.users.repository.BoatOwnerRepository;
import com.example.BookingApp.users.service.IBoatOwnerService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class BoatOwnerServiceImpl implements IBoatOwnerService {
    private final BoatOwnerRepository boatOwnerRepository;
    private PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public BoatOwnerServiceImpl(BoatOwnerRepository boatOwnerRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService, EmailSenderService emailSenderService) {
        this.boatOwnerRepository = boatOwnerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
        this.emailSenderService = emailSenderService;
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

    @Override
    public BoatOwner registerBoatOwner(BoatOwnerDTO dto) {
        BoatOwner b = BoatOwnerMapper.MapDTOToBoatOwner(dto);
        b.setPassword(passwordEncoder.encode(dto.getPassword()));
        b.setVerificationCode(RandomString.make(32));
        List<Authority> auth = authorityService.findByName("ROLE_BOAT_OWNER");
        b.setAuthorities(auth);
        boatOwnerRepository.save(b);
        emailSenderService.sendRegistrationConfirmationEmailForBO(b);

        return b;
    }
}
