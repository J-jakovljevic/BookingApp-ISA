package com.example.BookingApp.reservations.service.impl;
import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationMapper;
import com.example.BookingApp.reservations.mapper.ReservationMapper;
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
    private final EmailSenderService emailSenderService;


    @Override
    public List<QuickReservationDTO> findPreviousReservationsForClient(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findPreviousReservationsForClient(clientId,new Date()));
    }


    @Override
    public List<QuickReservationDTO> findFutureReservationsForClient(Long clientId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureReservationsForClient(clientId,new Date()));
    }

    @Override
    public boolean cancelledReservationExists(Long actionId,Long clientId) {
        List<QuickReservation> quickReservations = quickReservationRepository.cancelledReservationExists(actionId,clientId);
        if(quickReservations.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public int countNumberOfReservationsForClient(Long clientId) {
        return quickReservationRepository.findReservationsForClient(clientId).size();
    }

    @Override
    public List<QuickReservationDTO> findPreviousReservationsForCottageOwner(Long id) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findPreviousReservationsForCottageOwner(id,new Date()));
    }

    @Override
    public List<QuickReservationDTO> findFutureReservationsForCottageOwner(Long id) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureReservationsForCottageOwner(id,new Date()));
    }

    @Override
    public List<QuickReservationDTO> findPreviousReservationsForBoatOwner(Long id) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findPreviousReservationsForBoatOwner(id,new Date()));
    }

    @Override
    public List<QuickReservationDTO> findFutureReservationsForBoatOwner(Long id) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureReservationsForBoatOwner(id,new Date()));
    }

    @Override
    public Boolean checkPeriodQR(Long cottageId, ActionDTO action) {
        List<QuickReservationDTO> reservationsDTO = this.findFutureQuickReservationsForCottage(cottageId);
        Boolean flag = true;
        for(QuickReservationDTO r : reservationsDTO){
            if((action.getStartTime().after(r.getAction().getStartTime()) && (action.getStartTime().before(r.getAction().getEndTime()))) || (action.getEndTime().after(r.getAction().getStartTime()) && (action.getEndTime().before(r.getAction().getEndTime()))) || (action.getStartTime().before(r.getAction().getStartTime()) && action.getEndTime().after(r.getAction().getEndTime()))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public List<QuickReservationDTO> findFutureQuickReservationsForCottage(Long cottageId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureQuickReservationsForCottage(cottageId, new Date()));

    }

    @Override
    public List<QuickReservationDTO> findFutureQuickReservationsForBoat(Long boatId) {
        return QuickReservationMapper.MapToListDTO(quickReservationRepository.findFutureQuickReservationsForBoat(boatId, new Date()));    }

    @Override
    public double calculateCottageProfitForQR(Long cottageOwnerId, Date date) {
        List<QuickReservationDTO> reservationsDTO = this.findPreviousReservationsForCottageOwner(cottageOwnerId);
        double income = 0;
        for(QuickReservationDTO r : reservationsDTO){
            if(r.getAction().getStartTime().after(date)) {
                income += r.getAction().getPrice();
            }
        }
        System.out.println(income);
        return income;
    }

    @Override
    public double calculateBoatProfitForQR(Long boatOwnerId, Date date) {
        List<QuickReservationDTO> reservationsDTO = this.findPreviousReservationsForBoatOwner(boatOwnerId);
        double income = 0;
        for(QuickReservationDTO r : reservationsDTO){
            if(r.getAction().getStartTime().after(date)) {
                income += r.getAction().getPrice();
            }
        }
        System.out.println(income);
        return income;
    }

    @Override
    public Boolean checkPeriodQRForReservation(Long cottageId, ReservationDTO reservation) {
        List<QuickReservationDTO> reservationsDTO = this.findFutureQuickReservationsForCottage(cottageId);
        Boolean flag = true;
        for(QuickReservationDTO r : reservationsDTO){
            if((reservation.getStartTime().after(r.getAction().getStartTime()) && (reservation.getStartTime().before(r.getAction().getEndTime()))) || (reservation.getEndTime().after(r.getAction().getStartTime()) && (reservation.getEndTime().before(r.getAction().getEndTime()))) || (reservation.getStartTime().before(r.getAction().getStartTime()) && reservation.getEndTime().after(r.getAction().getEndTime()))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Boolean checkPeriodQRForBoat(Long boatId, ActionDTO action) {
        List<QuickReservationDTO> reservationsDTO = this.findFutureQuickReservationsForBoat(boatId);
        Boolean flag = true;
        for(QuickReservationDTO r : reservationsDTO){
            if((action.getStartTime().after(r.getAction().getStartTime()) && (action.getStartTime().before(r.getAction().getEndTime()))) || (action.getEndTime().after(r.getAction().getStartTime()) && (action.getEndTime().before(r.getAction().getEndTime()))) || (action.getStartTime().before(r.getAction().getStartTime()) && action.getEndTime().after(r.getAction().getEndTime()))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Boolean checkPeriodQRForReservationForBoat(Long boatId, ReservationDTO reservation) {
        List<QuickReservationDTO> reservationsDTO = this.findFutureQuickReservationsForBoat(boatId);
        Boolean flag = true;
        for(QuickReservationDTO r : reservationsDTO){
            if((reservation.getStartTime().after(r.getAction().getStartTime()) && (reservation.getStartTime().before(r.getAction().getEndTime()))) || (reservation.getEndTime().after(r.getAction().getStartTime()) && (reservation.getEndTime().before(r.getAction().getEndTime()))) || (reservation.getStartTime().before(r.getAction().getStartTime()) && reservation.getEndTime().after(r.getAction().getEndTime()))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean cancelReservation(Long reservationId) {
        QuickReservation reservation = findById(reservationId);
        Action action = actionService.findById(reservation.getAction().getId());
        action.setReserved(false);
        actionService.updateAction(action);
        reservation.setCancelled(true);
        quickReservationRepository.save(reservation);
         return true;
    }

    @Override
    public QuickReservation findById(Long reservationId) {
        return quickReservationRepository.getById(reservationId);
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
        action.setReserved(true);
        action = actionService.updateAction(action);
        newReservation.setAction(action);
        newReservation.setClient(clientService.findById(dto.getClient().getId()));
        QuickReservation q =  quickReservationRepository.save(newReservation);
        emailSenderService.sendQuickReservationConfirmationEmail(q);
        return q;
    }

}
