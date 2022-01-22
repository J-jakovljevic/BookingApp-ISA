package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.dto.LoyaltyProgramDTO;
import com.example.BookingApp.users.model.FishingInstructor;
import com.example.BookingApp.users.model.LoyaltyProgram;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyProgramMapper {
    public static LoyaltyProgramDTO MapToDTO(LoyaltyProgram c){
        LoyaltyProgramDTO dto = new LoyaltyProgramDTO(c.getId(),c.getPointsPerReservation(),c.getSilverMemberThreshold(),c.getGoldenMemberThreshold());
        return dto;
    }
    public static LoyaltyProgram MapToLoyaltyProgram(LoyaltyProgramDTO dto){
        LoyaltyProgram l = new LoyaltyProgram();
        l.setPointsPerReservation(dto.getPointsPerReservation());
        l.setSilverMemberThreshold(dto.getSilverMemberThreshold());
        l.setGoldenMemberThreshold(dto.getGoldenMemberThreshold());
        return l;
    }
}
