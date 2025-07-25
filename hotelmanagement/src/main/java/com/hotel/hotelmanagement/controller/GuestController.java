package com.hotel.hotelmanagement.controller;

import com.hotel.hotelmanagement.model.Guest;
import com.hotel.hotelmanagement.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "*") // allow frontend access
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    // Get all guests
    @GetMapping
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    // Add a new guest
    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }
}
