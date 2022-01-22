package com.example.BookingApp.renting.service.impl;

import com.example.BookingApp.renting.dto.SubscriptionDTO;
import com.example.BookingApp.renting.mapper.SubscriptionMapper;
import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.renting.repository.SubscriptionRepository;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.renting.service.ISubscriptionService;
import com.example.BookingApp.users.mapper.ClientMapper;
import com.example.BookingApp.users.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements ISubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final IRentingItemService rentingItemService;
    private final IClientService clientService;
    @Override
    public Subscription createSubscription(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = new Subscription();
        subscription.setClient(clientService.findById(subscriptionDTO.getUserId()));
        subscription.setRentingItem(rentingItemService.findById(subscriptionDTO.getRentingItemId()));
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription findById(Long id) {
        return subscriptionRepository.getById(id);
    }

    @Override
    public List<Subscription> getByClient(Long clientId) {
        return subscriptionRepository.findAllForClient(clientId);
    }

    @Override
    public boolean deleteSubscription(Long id) {
        try{
            subscriptionRepository.delete(findById(id));
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
