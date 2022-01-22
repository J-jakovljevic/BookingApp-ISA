package com.example.BookingApp.users.service.impl;

import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import com.example.BookingApp.reservations.service.IReservationService;
import com.example.BookingApp.users.dto.LoyaltyProgramDTO;
import com.example.BookingApp.users.dto.LoyaltyProgramStatusDTO;
import com.example.BookingApp.users.mapper.LoyaltyProgramMapper;
import com.example.BookingApp.users.model.LoyaltyProgram;
import com.example.BookingApp.users.repository.LoyaltyProgramRepository;
import com.example.BookingApp.users.service.ILoyaltyProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoyaltyProgramServiceImpl implements ILoyaltyProgramService {
    private final LoyaltyProgramRepository repository;
    private final IReservationService reservationService;
    private final IQuickReservationService quickReservationService;

    @Override
    public LoyaltyProgram create(LoyaltyProgramDTO dto) {
        return repository.save(LoyaltyProgramMapper.MapToLoyaltyProgram(dto));
    }

    @Override
    public LoyaltyProgram update(LoyaltyProgramDTO dto) {
        LoyaltyProgram l = getLoyaltyProgram();
        l.setGoldenMemberThreshold(dto.getGoldenMemberThreshold());
        l.setSilverMemberThreshold(dto.getSilverMemberThreshold());
        l.setPointsPerReservation(dto.getPointsPerReservation());
        return repository.save(l);
    }

    @Override
    public LoyaltyProgram getLoyaltyProgram() {
        return repository.findAll().get(0);
    }

    @Override
    public LoyaltyProgramStatusDTO getLoyaltyProgramStatusByClient(Long clientId) {
        LoyaltyProgram l = getLoyaltyProgram();
        int numberOfReservations = reservationService.countNumberOfReservationsForClient(clientId);
        int numberOfQuickReservations = quickReservationService.countNumberOfReservationsForClient(clientId);
        if(((numberOfQuickReservations + numberOfReservations) * l.getPointsPerReservation()) > l.getSilverMemberThreshold()){
            return new LoyaltyProgramStatusDTO("Silver");
        }
        else if (((numberOfQuickReservations + numberOfReservations) * l.getPointsPerReservation()) > l.getGoldenMemberThreshold()){
            return new LoyaltyProgramStatusDTO("Golden");
        }
        return new LoyaltyProgramStatusDTO("Regular");
    }
}
