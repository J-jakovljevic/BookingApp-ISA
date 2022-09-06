package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.renting.service.ISubscriptionService;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.mapper.ActionMapper;
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
    private final IRentingItemService rentingItemService;

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

    @Override
    public Action createAction(ActionDTO dto) {
        Action action = ActionMapper.MapDTOToAction(dto);
        action.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        actionRepository.save(action);
        return action;
    }

    @Override
    public List<Action> getCurrentActionsForBoatOwner(Long ownerId) {
            return actionRepository.getCurrentActionsByBoatOwnerId(ownerId, new Date());
    }

    @Override
    public List<Action> getCurrentActionsForCottageOwner(Long ownerId) {
        return actionRepository.getCurrentActionsByCottageOwnerId(ownerId, new Date());
    }

    @Override
    public Action getActionById(Long id) {
        return actionRepository.getCurrentActionById(id);

    }

    @Override
    public void delete(Long actionId) {
        actionRepository.delete(findById(actionId));
    }
}
