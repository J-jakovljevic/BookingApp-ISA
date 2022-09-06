package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.email.service.EmailSenderService;
import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.service.IAdditionalServiceService;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.mapper.ReservationMapper;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.repository.ReservationRepository;
import com.example.BookingApp.reservations.service.IReservationService;
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
        /*for(AdditionalServiceDTO a : dto.getAdditionalServices()){
            additionalServices.add(additionalServiceService.findById(a.getId()));
        }*/
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
        Reservation reservation = reservationRepository.getById(reservationId);
        reservation.setCancelled(true);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public boolean cancelledReservationExists(CancellationCheckDTO dto) {
        List<Reservation> reservations = reservationRepository.cancelledReservationExists(dto.getClientId(),dto.getRentingItemId(),dto.getStartTime(),dto.getEndTime());
        if(reservations.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public int countNumberOfReservationsForClient(Long clientId) {
        return reservationRepository.findReservationsForClient(clientId).size();
    }

    @Override
    public List<ReservationDTO> findAllReservationsForCottage(Long cottageId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findAllReservationsForCottage(cottageId));
    }

    @Override
    public List<ReservationDTO> findFutureReservationsForCottageOwner(Long cottageOwnerId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findFutureReservationsForCottageOwner(cottageOwnerId,new Date()));
    }

    @Override
    public List<ReservationDTO> findPreviousReservationsForCottageOwner(Long cottageOwnerId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findPreviousReservationsForCottageOwner(cottageOwnerId,new Date()));
    }

    @Override
    public List<ReservationDTO> findPreviousReservationsForBoatOwner(Long boatOwnerId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findPreviousReservationsForBoatOwner(boatOwnerId,new Date()));
    }

    @Override
    public List<ReservationDTO> findFutureReservationsForBoatOwner(Long boatOwnerId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findFutureReservationsForBoatOwner(boatOwnerId,new Date()));
    }

    @Override
    public List<ReservationDTO> findFutureReservationsForCottage(Long cottageId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findFutureReservationsForCottage(cottageId, new Date()));
    }

    @Override
    public List<ReservationDTO> findFutureReservationsForBoat(Long boatId) {
        return ReservationMapper.MapToListDTO(reservationRepository.findFutureReservationsForBoat(boatId, new Date()));
    }

    @Override
    public Boolean checkPeriod(Long cottageId, ActionDTO action) {
         List<ReservationDTO> reservationsDTO = this.findFutureReservationsForCottage(cottageId);
        Boolean flag = true;
         for(ReservationDTO r : reservationsDTO){
             if((action.getStartTime().after(r.getStartTime()) && (action.getStartTime().before(r.getEndTime()))) || (action.getEndTime().after(r.getStartTime()) && (action.getEndTime().before(r.getEndTime()))) || (action.getStartTime().before(r.getStartTime()) && action.getEndTime().after(r.getEndTime()))){
                 flag = false;
             }
         }
         return flag;
    }

    @Override
    public double calculateCottageProfitForReservations(Long cottageOwnerId, Date startDate) {
        List<ReservationDTO> reservationsDTO = this.findPreviousReservationsForCottageOwner(cottageOwnerId);
        double income = 0;
        for(ReservationDTO r : reservationsDTO){
            if(r.getStartTime().after(startDate)) {
                income += r.getPrice();
            }
        }
        System.out.println(income);
        return income;
    }

    @Override
    public double calculateBoatProfitForReservations(Long boatOwnerId, Date date) {
        List<ReservationDTO> reservationsDTO = this.findPreviousReservationsForBoatOwner(boatOwnerId);
        double income = 0;
        for(ReservationDTO r : reservationsDTO){
            if(r.getStartTime().after(date)) {
                income += r.getPrice();
            }
        }
        System.out.println(income);
        return income;
    }

    @Override
    public Boolean checkPeriodForReservation(Long cottageId, ReservationDTO reservation) {
        List<ReservationDTO> reservationsDTO = this.findFutureReservationsForCottage(cottageId);
        Boolean flag = true;
        for(ReservationDTO r : reservationsDTO){
            if((reservation.getStartTime().after(r.getStartTime()) && (reservation.getStartTime().before(r.getEndTime()))) || (reservation.getEndTime().after(r.getStartTime()) && (reservation.getEndTime().before(r.getEndTime()))) || (reservation.getStartTime().before(r.getStartTime()) && reservation.getEndTime().after(r.getEndTime()))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Boolean checkPeriodForBoat(Long boatId, ActionDTO action) {
        List<ReservationDTO> reservationsDTO = this.findFutureReservationsForBoat(boatId);
        Boolean flag = true;
        for(ReservationDTO r : reservationsDTO){
            if((action.getStartTime().after(r.getStartTime()) && (action.getStartTime().before(r.getEndTime()))) || (action.getEndTime().after(r.getStartTime()) && (action.getEndTime().before(r.getEndTime()))) || (action.getStartTime().before(r.getStartTime()) && action.getEndTime().after(r.getEndTime()))){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Boolean checkPeriodForReservationForBoat(Long boatId, ReservationDTO reservation) {
        List<ReservationDTO> reservationsDTO = this.findFutureReservationsForBoat(boatId);
        Boolean flag = true;
        for(ReservationDTO r : reservationsDTO){
            if((reservation.getStartTime().after(r.getStartTime()) && (reservation.getStartTime().before(r.getEndTime()))) || (reservation.getEndTime().after(r.getStartTime()) && (reservation.getEndTime().before(r.getEndTime()))) || (reservation.getStartTime().before(r.getStartTime()) && reservation.getEndTime().after(r.getEndTime()))){
                flag = false;
            }
        }
        return flag;
    }
}
