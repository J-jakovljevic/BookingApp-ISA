package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.mapper.ClientMapper;
import com.example.BookingApp.users.model.Authority;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.repository.ClientRepository;
import com.example.BookingApp.users.service.IClientService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService, EmailSenderService emailSenderService) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Client registerClient(ClientDTO dto) {
        Client c = ClientMapper.MapDTOToClient(dto);
        c.setPassword(passwordEncoder.encode(dto.getPassword()));
        c.setVerificationCode(RandomString.make(32));
        List<Authority> auth = authorityService.findByName("ROLE_CLIENT");
        c.setAuthorities(auth);
        clientRepository.save(c);
        emailSenderService.sendRegistrationConfirmationEmail(c);

        return c;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        return ClientMapper.MapToListDTOS(clients);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public ClientDTO updateClient(ClientDTO dto) {
        Client c = clientRepository.getById(dto.getId());
        c.setSurname(dto.getSurname());
        c.setName(dto.getName());
        c.setPhoneNumber(dto.getPhoneNumber());
        c.setAddress(dto.getAddress());
        clientRepository.save(c);
        return ClientMapper.MapToDTO(c);
    }

    @Override
    public Client activateClient(String activationToken) {
        Client c = clientRepository.findByVerificationCode(activationToken);
        c.setEnabled(true);
        return clientRepository.save(c);
    }
}
