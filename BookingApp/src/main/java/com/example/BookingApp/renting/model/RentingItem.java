package com.example.BookingApp.renting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Inheritance(strategy=TABLE_PER_CLASS)
@Getter
@Setter
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
    private int capacity;
}
