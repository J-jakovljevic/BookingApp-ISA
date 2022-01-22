package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.reservations.dto.QuickReservationPenaltyDTO;
import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import com.example.BookingApp.reservations.repository.QuickReservationPenaltyRepository;
import com.example.BookingApp.reservations.service.IQuickReservationPenaltyService;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuickReservationPenaltyServiceImpl implements IQuickReservationPenaltyService {
    private final QuickReservationPenaltyRepository penaltyRepository;
    private final IQuickReservationService quickReservationService;

    @Override
    public QuickReservationPenalty createPenalty(QuickReservationPenaltyDTO penaltyDTO) {
        QuickReservationPenalty penalty = new QuickReservationPenalty();
        penalty.setQuickReservation(quickReservationService.findById(penaltyDTO.getQuickReservationId()));
        return penaltyRepository.save(penalty);
    }

    @Override
    public List<QuickReservationPenalty> getByClient(Long clientId) {
        return penaltyRepository.getAllByClient(clientId);
    }

    @Override
    @Scheduled(cron="0 0 0 1 1/1 *")
    public void deleteAll() {
        penaltyRepository.deleteAll();
    }
}
