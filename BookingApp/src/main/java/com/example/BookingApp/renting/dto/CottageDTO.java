package com.example.BookingApp.renting.dto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CottageDTO extends RentingItemDTO{
    private String rules;
    private Long ownerId;

    public CottageDTO() {}

    public CottageDTO(Long id, String name, String address, String description, String rules, int capacity, Long ownerId) {
        super(id,name,address,description,capacity, "Cottage", 0);

        this.rules = rules;
        this.ownerId = ownerId;
    }

}
