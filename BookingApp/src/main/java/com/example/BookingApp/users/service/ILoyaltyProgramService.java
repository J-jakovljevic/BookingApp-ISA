package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.LoyaltyProgramDTO;
import com.example.BookingApp.users.dto.LoyaltyProgramStatusDTO;
import com.example.BookingApp.users.model.LoyaltyProgram;

public interface ILoyaltyProgramService {
    LoyaltyProgram create(LoyaltyProgramDTO dto);
    LoyaltyProgram update(LoyaltyProgramDTO dto);
    LoyaltyProgram getLoyaltyProgram();
    LoyaltyProgramStatusDTO getLoyaltyProgramStatusByClient(Long clientId);
}
