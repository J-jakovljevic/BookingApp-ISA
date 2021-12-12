package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.model.Action;

public interface IActionService {
    Action findById(Long actionId);
    Action updateAction(Action action);

}
