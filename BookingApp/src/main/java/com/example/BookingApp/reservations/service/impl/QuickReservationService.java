package com.example.BookingApp.reservations.service.impl;
import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationMapper;
import com.example.BookingApp.reservations.model.Action;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.repository.QuickReservationRepository;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import com.example.BookingApp.users.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuickReservationService implements IQuickReservationService {
    private final QuickReservationRepository quickReservationRepository;
    private final ActionService actionService;
    private final IClientService clientService;


    @Override
    public List<QuickReservationDTO> findPreviousReservationsForClient(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findPreviousReservationsForClient(clientId,new Date()));
    }


    @Override
    public List<QuickReservationDTO> findFutureReservationsForClient(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureReservationsForClient(clientId,new Date()));
    }

    @Override
    public boolean cancelReservation(Long reservationId) {
        QuickReservation reservation = findById(reservationId);
        Action action = actionService.findById(reservation.getAction().getId());
        action.setReserved(false);
        actionService.updateAction(action);
        quickReservationRepository.delete(reservation);
         return true;
    }

    @Override
    public QuickReservation findById(Long reservationId) {
        return quickReservationRepository.findById(reservationId).get();
    }

    @Override
    public List<QuickReservation> findAll() {
        return quickReservationRepository.findAll();
    }

    @Override
    public QuickReservation createReservation(QuickReservationDTO dto) {
        QuickReservation newReservation = QuickReservationMapper.MapDTOToQuickReservation(dto);
        Action action = actionService.findById(dto.getAction().getId());
        action.setReserved(true);
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        action.setStartTime(tomorrow);
        action = actionService.updateAction(action);
        newReservation.setAction(action);
        newReservation.setClient(clientService.findById(dto.getClient().getId()));
        return quickReservationRepository.save(newReservation);
    }

}
