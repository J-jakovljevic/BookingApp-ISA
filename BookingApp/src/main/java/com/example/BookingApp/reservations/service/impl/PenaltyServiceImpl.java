package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.reservations.dto.PenaltyDTO;
import com.example.BookingApp.reservations.model.Penalty;
import com.example.BookingApp.reservations.repository.PenaltyRepository;
import com.example.BookingApp.reservations.service.IPenaltyService;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PenaltyServiceImpl implements IPenaltyService {
    private final PenaltyRepository penaltyRepository;
    private final IQuickReservationService quickReservationService;

    @Override
    public Penalty createPenalty(PenaltyDTO penaltyDTO) {
        Penalty penalty = new Penalty();
        penalty.setQuickReservation(quickReservationService.findById(penaltyDTO.getQuickReservationId()));
        return penaltyRepository.save(penalty);
    }

    @Override
    public List<Penalty> getByClient(Long clientId) {
        List<Penalty> allPenalties = penaltyRepository.findAll();
        List<Penalty> filteredPenalties = new ArrayList<Penalty>();
        for(Penalty p : allPenalties){
            if(p.getQuickReservation().getClient().getId().equals(clientId)){
                filteredPenalties.add(p);
            }
        }
        return filteredPenalties;
    }
}
