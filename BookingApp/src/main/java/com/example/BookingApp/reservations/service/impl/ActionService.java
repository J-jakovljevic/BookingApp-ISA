package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.reservations.model.Action;
import com.example.BookingApp.reservations.repository.ActionRepository;
import com.example.BookingApp.reservations.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService implements IActionService {
    private final ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public Action findById(Long actionId) {
        return actionRepository.findById(actionId).get();
    }

    @Override
    public Action updateAction(Action action) {
        return actionRepository.save(action);
    }
}
