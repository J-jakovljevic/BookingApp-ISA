package com.example.BookingApp.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SystemAdmin")
public class SystemAdmin extends User {
}
