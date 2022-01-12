package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.RevisionDTO;
import com.example.BookingApp.reservations.model.Revision;

public interface IRevisionService {
    double countAverageGradeForRentingItem(Long rentingItemId);
    Revision create(RevisionDTO dto);
}
