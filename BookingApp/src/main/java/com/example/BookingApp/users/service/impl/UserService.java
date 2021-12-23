package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.users.model.User;
import com.example.BookingApp.users.repository.UserRepository;
import com.example.BookingApp.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }
}
