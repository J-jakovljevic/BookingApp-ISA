package com.example.BookingApp.reservations.dto;
import com.example.BookingApp.users.dto.ClientDTO;

import javax.persistence.*;

public class QuickReservationDTO {
    private Long id;
    private ClientDTO client;
    private ActionDTO action;

    public QuickReservationDTO() {}

    public QuickReservationDTO(Long id, ClientDTO client, ActionDTO action) {
        this.id = id;
        this.client = client;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public ActionDTO getAction() {
        return action;
    }

    public void setAction(ActionDTO action) {
        this.action = action;
    }
}
