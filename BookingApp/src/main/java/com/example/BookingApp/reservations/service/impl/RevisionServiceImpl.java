package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.reservations.dto.RevisionDTO;
import com.example.BookingApp.reservations.mapper.RevisionMapper;
import com.example.BookingApp.reservations.model.Revision;
import com.example.BookingApp.reservations.repository.RevisionRepository;
import com.example.BookingApp.reservations.service.IRevisionService;
import com.example.BookingApp.users.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevisionServiceImpl implements IRevisionService
{
    private final RevisionRepository revisionRepository;
    private final IClientService clientService;
    private final IRentingItemService rentingItemService;

    @Override
    public double countAverageGradeForRentingItem(Long rentingItemId) {
        List<Revision> revisionsForRentingItem = revisionRepository.findRevisionsForRentingItem(rentingItemId);
        double averageGrade = 0;
        for(Revision r : revisionsForRentingItem){
            averageGrade += r.getGrade();
        }
        return averageGrade/revisionsForRentingItem.size();
    }

    @Override
    public Revision create(RevisionDTO dto) {
        Revision r = RevisionMapper.MapDTOToRevision(dto);
        r.setClient(clientService.findById(dto.getClientId()));
        r.setApproved(false);
        r.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        return revisionRepository.save(r);
    }

    @Override
    public void approveRevision(Long revisionId) {
        Revision r = revisionRepository.getById(revisionId);
        r.setApproved(true);
        revisionRepository.save(r);
    }

    @Override
    public void deleteRevision(Long revisionId) {
        revisionRepository.delete(revisionRepository.getById(revisionId));
    }

    @Override
    public List<Revision> getAllUnapprovedRevisions() {
        return revisionRepository.getAllUnapprovedRevisions();
    }

    @Override
    public Revision findById(Long revisionId) {
        return revisionRepository.getById(revisionId);
    }

    @Override
    public Revision getRevisionForReservation(Long reservationId) {
        return revisionRepository.getRevisionForReservation(reservationId);
    }
}
