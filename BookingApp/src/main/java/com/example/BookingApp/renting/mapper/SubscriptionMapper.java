package com.example.BookingApp.renting.mapper;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.dto.SubscriptionDTO;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.renting.service.impl.RentingItemService;
import com.example.BookingApp.users.mapper.ClientMapper;
import com.example.BookingApp.users.service.IClientService;
import com.example.BookingApp.users.service.impl.ClientService;
import com.example.BookingApp.users.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

public class SubscriptionMapper {
    private static  IClientService clientService;
    private static  IRentingItemService rentingItemService;

    public static Subscription MapDTOToSubscription(SubscriptionDTO dto){
        Subscription s = new Subscription();
        s.setClient(clientService.findById(dto.getUserId()));
        s.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        return s;
    }

    public static SubscriptionDTO MapToDTO(Subscription s){
        SubscriptionDTO dto= new SubscriptionDTO(s.getId(),s.getClient().getId(),s.getRentingItem().getId());
        return dto;
    }

    public static List<SubscriptionDTO> MapToListDTO(List<Subscription> subscriptions){
        List<SubscriptionDTO> dtos = new ArrayList<SubscriptionDTO>();
        for(Subscription s : subscriptions){
            dtos.add(MapToDTO(s));
        }
        return dtos;
    }

    public static List<Subscription> MapDTOSToList(List<SubscriptionDTO> dtos){
        List<Subscription> subscriptions = new ArrayList<Subscription>();
        for(SubscriptionDTO dto : dtos){
            subscriptions.add(MapDTOToSubscription(dto));
        }
        return subscriptions;
    }
}
