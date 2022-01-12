package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.renting.mapper.BoatMapper;
import com.example.BookingApp.renting.mapper.RentingItemMapper;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.renting.service.IRentingItemService;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.model.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ActionMapper {
    private static IRentingItemService rentingItemService;

    @Autowired
    public ActionMapper(IRentingItemService rentingItemService) {
        this.rentingItemService = rentingItemService;
    }

    public static Action MapDTOToAction(ActionDTO dto){
        Action a = new Action();
        a.setEndTime(dto.getEndTime());
        a.setPrice(dto.getPrice());
        a.setStartTime(dto.getStartTime());
     //   a.setRentingItem(rentingItemService.findById(dto.getRentingItemId()));
        a.setReserved(dto.isReserved());
        return a;
    }

    public static ActionDTO MapToDTO(Action a){
        ActionDTO dto= new ActionDTO(a.getId(), RentingItemMapper.MapToDTO(a.getRentingItem()),a.getStartTime(),a.getEndTime(),a.getPrice(),a.isReserved(),a.getRentingItem().getId());
        return dto;
    }

    public static List<ActionDTO> MapToListDTO(List<Action> actions){
        List<ActionDTO> dtos = new ArrayList<ActionDTO>();
        for(Action a  : actions){
            dtos.add(MapToDTO(a));
        }
        return dtos;
    }

    public static List<Action> MapDTOSToList(List<ActionDTO> dtos){
        List<Action> actions = new ArrayList<Action>();
        for(ActionDTO dto : dtos){
            actions.add(MapDTOToAction(dto));
        }
        return actions;
    }
}
