package com.example.BookingApp.users.model;

import com.example.BookingApp.renting.model.RentingItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintReply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Client reciever;
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private RentingItem rentingItem;

}
