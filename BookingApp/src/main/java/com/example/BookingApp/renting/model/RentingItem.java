package com.example.BookingApp.renting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Inheritance(strategy=TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type", discriminatorType=DiscriminatorType.STRING)
public abstract class RentingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    private String name;
    private String address;
    private String description;
    @Column(insertable = false, updatable = false)
    private String type;

    public RentingItem() {}

    public RentingItem(Long id, String name, String address, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
