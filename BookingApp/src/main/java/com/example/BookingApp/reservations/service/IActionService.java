package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.model.Action;

import java.util.List;

public interface IActionService {
    Action findById(Long actionId);
    Action updateAction(Action action);
    List<Action> getCurrentActionsForClient(Long clientId);

}
