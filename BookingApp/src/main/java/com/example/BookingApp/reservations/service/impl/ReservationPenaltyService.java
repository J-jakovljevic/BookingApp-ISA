package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.reservations.dto.QuickReservationPenaltyDTO;
import com.example.BookingApp.reservations.dto.ReservationPenaltyDTO;
import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import com.example.BookingApp.reservations.model.ReservationPenalty;
import com.example.BookingApp.reservations.repository.QuickReservationPenaltyRepository;
import com.example.BookingApp.reservations.repository.ReservationPenaltyRepository;
import com.example.BookingApp.reservations.service.IQuickReservationPenaltyService;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import com.example.BookingApp.reservations.service.IReservationPenaltyService;
import com.example.BookingApp.reservations.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationPenaltyService implements IReservationPenaltyService
{
    private final ReservationPenaltyRepository penaltyRepository;
    private final IReservationService reservationService;

    @Override
    public ReservationPenalty createPenalty(ReservationPenaltyDTO penaltyDTO) {
        ReservationPenalty penalty = new ReservationPenalty();
        penalty.setReservation(reservationService.findById(penaltyDTO.getReservationId()));
        return penaltyRepository.save(penalty);
    }

    @Override
    public List<ReservationPenalty> getByClient(Long clientId) {
        return penaltyRepository.getAllByClient(clientId);
    }

    @Override
    @Scheduled(cron="0 0 0 1 1/1 *")
    public void deleteAll() {
            this.penaltyRepository.deleteAll();
    }
}
