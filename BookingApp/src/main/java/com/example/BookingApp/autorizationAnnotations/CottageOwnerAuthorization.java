package com.example.BookingApp.autorizationAnnotations;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('COTTAGEOWNER')")
public @interface CottageOwnerAuthorization {
}
