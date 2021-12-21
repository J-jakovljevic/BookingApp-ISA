package com.example.BookingApp.reservations.service.impl;
import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationMapper;
import com.example.BookingApp.reservations.model.Action;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.repository.QuickReservationRepository;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuickReservationService implements IQuickReservationService {
    private final QuickReservationRepository quickReservationRepository;
    private final ActionService actionService;
    private final EmailSenderService emailSenderService;


    @Override
    public List<QuickReservationDTO> findBoatReservationsForClient(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findBoatReservationsForClient(clientId));
    }
    @Override
    public List<QuickReservationDTO> findCottageReservationsForClient(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findCottageReservationsForClient(clientId));
    }
    @Override
    public List<QuickReservationDTO> findFishingInstructorClassReservationsForClient(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFishingInstructorClassReservationsForClient(clientId));
    }

    @Override
    public List<QuickReservationDTO> findFutureBoatReservations(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureBoatReservationsForClient(clientId,new Date()));
    }

    @Override
    public List<QuickReservationDTO> findFutureCottageReservations(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureCottageReservationsForClient(clientId,new Date()));
    }

    @Override
    public List<QuickReservationDTO> findFutureFishingInstructorClassReservations(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureFishingInstructorClassReservationsForClient(clientId,new Date()));
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

}
