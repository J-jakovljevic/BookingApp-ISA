package com.example.BookingApp.reservations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="replies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RevisionReply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Revision revision;
    private Long ownerId;
    private String description;
    private boolean approved;
}
