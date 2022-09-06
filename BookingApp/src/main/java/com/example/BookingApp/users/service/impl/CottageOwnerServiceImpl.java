package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.mapper.BoatOwnerMapper;
import com.example.BookingApp.users.mapper.CottageOwnerMapper;
import com.example.BookingApp.users.model.Authority;
import com.example.BookingApp.users.model.BoatOwner;
import com.example.BookingApp.users.model.CottageOwner;
import com.example.BookingApp.users.repository.CottageOwnerRepository;
import com.example.BookingApp.users.service.ICottageOwnerService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageOwnerServiceImpl implements ICottageOwnerService {
    private final CottageOwnerRepository cottageOwnerRepository;
    private PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;
    private final EmailSenderService emailSenderService;

    @Autowired
    private CottageOwnerServiceImpl(CottageOwnerRepository cottageOwnerRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService, EmailSenderService emailSenderService){
        this.cottageOwnerRepository = cottageOwnerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
        this.emailSenderService = emailSenderService;
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

    @Override
    public CottageOwner registerCottageOwner(CottageOwnerDTO dto) {
        CottageOwner c = CottageOwnerMapper.MapDTOToCottageOwner(dto);
        c.setPassword(passwordEncoder.encode(dto.getPassword()));
        c.setVerificationCode(RandomString.make(32));
        List<Authority> auth = authorityService.findByName("ROLE_COTTAGE_OWNER");
        c.setAuthorities(auth);
        cottageOwnerRepository.save(c);
        emailSenderService.sendRegistrationConfirmationEmailForCO(c);

        return c;
    }

}
