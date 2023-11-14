package org.example.microservices.guest.service;

import org.example.model.Guest;

public interface GuestService {
    Guest getGuestById(String guestId);
}
