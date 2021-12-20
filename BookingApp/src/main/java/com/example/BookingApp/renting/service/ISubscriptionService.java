package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.SubscriptionDTO;
import com.example.BookingApp.renting.model.Subscription;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISubscriptionService {
    Subscription createSubscription(SubscriptionDTO subscriptionDTO);
    Subscription findById(Long id);
    List<Subscription> getByClient(Long clientId);
    boolean deleteSubscription(Long id);
}
