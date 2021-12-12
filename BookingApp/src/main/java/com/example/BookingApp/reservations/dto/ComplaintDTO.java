package com.example.BookingApp.reservations.dto;
import com.example.BookingApp.users.dto.ClientDTO;

import javax.persistence.*;

public class ComplaintDTO {
    private Long id;
    private ClientDTO client;
    private Long rentingItemId;
    private String content;

    public ComplaintDTO() {}

    public ComplaintDTO(Long id, ClientDTO client, Long rentingItemId, String content) {
        this.id = id;
        this.client = client;
        this.rentingItemId = rentingItemId;
        this.content = content;
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

    public Long getRentingItemId() {
        return rentingItemId;
    }

    public void setRentingItemId(Long rentingItemId) {
        this.rentingItemId = rentingItemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
