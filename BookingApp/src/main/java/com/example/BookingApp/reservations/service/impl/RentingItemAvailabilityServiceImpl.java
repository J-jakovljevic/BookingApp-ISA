package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.reservations.dto.RentingItemAvailabilityDTO;
import com.example.BookingApp.reservations.dto.SearchReservationQueryDTO;
import com.example.BookingApp.reservations.mapper.RentingItemAvailabilityMapper;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.RentingItemAvailability;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.repository.RentingItemAvailabilityRepository;
import com.example.BookingApp.reservations.service.IRentingItemAvailaibilityService;
import com.example.BookingApp.reservations.service.IRevisionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RentingItemAvailabilityServiceImpl implements IRentingItemAvailaibilityService {
    private final RentingItemAvailabilityRepository rentingItemAvailabilityRepository;
    private final IRentingItemService rentingItemService;
    private final ReservationServiceImpl reservationService;
    private final QuickReservationService quickReservationService;
    private final IRevisionService revisionService;

    @Override
    public RentingItemAvailability create(RentingItemAvailabilityDTO dto) {
        RentingItemAvailability rentingItemAvailability = RentingItemAvailabilityMapper.MapDTOToRentingItemAvailability(dto);
        rentingItemAvailability.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        return rentingItemAvailabilityRepository.save(rentingItemAvailability);
    }

    @Override
    public List<RentingItemAvailability> search(SearchReservationQueryDTO dto) {
        if(dto.getLocation() == null && dto.getGrade() == 0){
            return removeReserved(rentingItemAvailabilityRepository.searchByParameters(dto.getStartDate(),dto.getEndDate(),dto.getCapacity(),dto.getRentingItemType()),dto);
        }
        else{
            return checkExtraFilters(removeReserved(rentingItemAvailabilityRepository.searchByParameters(dto.getStartDate(),dto.getEndDate(),dto.getCapacity(),dto.getRentingItemType()),dto),dto);
        }

    }

    @Override
    public List<RentingItemAvailability> removeReserved(List<RentingItemAvailability> rentingItemAvailabilities,SearchReservationQueryDTO dto) {
        List<RentingItemAvailability> availabilities = rentingItemAvailabilities;
        List<QuickReservation> quickReservations = quickReservationService.findAll();
        Iterator<RentingItemAvailability> iter = availabilities.iterator();

        while (iter.hasNext()) {
            RentingItemAvailability r = iter.next();
            for(QuickReservation q : quickReservations){
                if(overlap(dto.getStartDate(),dto.getEndDate(),q.getAction().getStartTime(),q.getAction().getEndTime())
                        && r.getRentingItem().getId().equals(q.getAction().getRentingItem().getId())){
                    iter.remove();
                }
            }
        }

        iter = availabilities.iterator();
        Iterator<RentingItemAvailability> iter1 = availabilities.iterator();
        List<Reservation> reservations = reservationService.findAll();

        while (iter.hasNext()) {
            RentingItemAvailability r1 = iter.next();
                for(Reservation reservation : reservations){
                    if(overlap(dto.getStartDate(),dto.getEndDate(),reservation.getStartTime(),reservation.getEndTime())
                            && r1.getRentingItem().getId().equals(reservation.getRentingItem().getId())){
                        iter.remove();
                    }
            }
        }

        return availabilities;
    }

    @Override
    public List<RentingItemAvailability> checkExtraFilters(List<RentingItemAvailability> rentingItemAvailabilities, SearchReservationQueryDTO dto) {
        List<RentingItemAvailability> filteredAvailabilities = new ArrayList<>();
        for(RentingItemAvailability r : rentingItemAvailabilities) {
            double averageGrade = revisionService.countAverageGradeForRentingItem(r.getRentingItem().getId());
            if(averageGrade >= dto.getGrade()){
                if(dto.getLocation()!=null){
                    if(r.getRentingItem().getAddress().toLowerCase().contains(dto.getLocation().toLowerCase())){
                        filteredAvailabilities.add(r);
                    }
                }
                else{
                    filteredAvailabilities.add(r);
                }
            }
        }
        return filteredAvailabilities;
    }

    boolean overlap(Date start1, Date end1, Date start2, Date end2){
        return start1.before(end2) && start2.before(end1);
    }
}
