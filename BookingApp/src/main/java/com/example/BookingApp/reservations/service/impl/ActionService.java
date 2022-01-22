package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.renting.service.ISubscriptionService;
import com.example.BookingApp.reservations.model.Action;
import com.example.BookingApp.reservations.repository.ActionRepository;
import com.example.BookingApp.reservations.service.IActionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionService implements IActionService {
    private final ActionRepository actionRepository;
    private final ISubscriptionService subscriptionService;

    @Override
    public Action findById(Long actionId) {
        return actionRepository.findById(actionId).get();
    }

    @Override
    public Action updateAction(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public List<Action> getCurrentActionsForClient(Long clientId) {
        List<Subscription> subscriptionsForClient = subscriptionService.getByClient(clientId);
        List<Action> currentActions = actionRepository.getCurrentActions(new Date());
        List<Action> actionsForClient = new ArrayList<>();
        for(Subscription s : subscriptionsForClient){
           for(Action a : currentActions){
               if(s.getRentingItem().getId().equals(a.getRentingItem().getId())){
                   actionsForClient.add(a);
               }
           }
        }
        return actionsForClient;
    }
}
