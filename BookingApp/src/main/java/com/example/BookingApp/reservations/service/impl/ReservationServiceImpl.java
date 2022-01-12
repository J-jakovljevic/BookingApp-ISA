package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.service.IAdditionalServiceService;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationMapper;
import com.example.BookingApp.reservations.mapper.ReservationMapper;
import com.example.BookingApp.reservations.model.Action;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.repository.ReservationRepository;
import com.example.BookingApp.reservations.service.IReservationService;
import com.example.BookingApp.users.repository.ClientRepository;
import com.example.BookingApp.users.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements IReservationService
{
    private final ReservationRepository reservationRepository;
    private final IClientService clientService;
    private final IAdditionalServiceService additionalServiceService;
    private final IRentingItemService rentingItemService;
    private final EmailSenderService emailSenderService;

    @Override
    public Reservation create(ReservationDTO dto) {
        Reservation reservation = ReservationMapper.MapDTOToReservation(dto);
        reservation.setClient(clientService.findById(dto.getClientId()));
        reservation.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        List<AdditionalService> additionalServices = new ArrayList<AdditionalService>();
        for(AdditionalServiceDTO a : dto.getAdditionalServices()){
            additionalServices.add(additionalServiceService.findById(a.getId()));
        }
        reservation.setAdditionalServices(additionalServices);
        emailSenderService.sendReservationConfirmationEmail(reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<ReservationDTO> findPreviousReservationsForClient(Long clientId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findPreviousReservationsForClient(clientId,new Date()));
    }


    @Override
    public List<ReservationDTO> findFutureReservationsForClient(Long clientId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findFutureReservationsForClient(clientId,new Date()));
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.getById(id);
    }


    @Override
    public boolean cancelReservation(Long reservationId) {
        reservationRepository.delete(reservationRepository.getById(reservationId));
        return true;
    }


}
