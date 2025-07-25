package com.hotel.hotelmanagement.controller;

import com.hotel.hotelmanagement.model.Booking;
import com.hotel.hotelmanagement.model.Guest;
import com.hotel.hotelmanagement.model.Room;
import com.hotel.hotelmanagement.repository.BookingRepository;
import com.hotel.hotelmanagement.repository.GuestRepository;
import com.hotel.hotelmanagement.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request) {
        Guest guest = guestRepository.findById(request.getGuestId()).orElseThrow();
        Room room = roomRepository.findById(request.getRoomId().intValue()).orElseThrow();

        Booking booking = new Booking(guest, room, request.getCheckInDate(), request.getCheckOutDate());
        return bookingRepository.save(booking);
    }

    // Inner class to receive booking data
    static class BookingRequest {
        private Long guestId;
        private Long roomId;
        private java.time.LocalDate checkInDate;
        private java.time.LocalDate checkOutDate;

        // Getters and Setters
        public Long getGuestId() { return guestId; }
        public void setGuestId(Long guestId) { this.guestId = guestId; }

        public Long getRoomId() { return roomId; }
        public void setRoomId(Long roomId) { this.roomId = roomId; }

        public java.time.LocalDate getCheckInDate() { return checkInDate; }
        public void setCheckInDate(java.time.LocalDate checkInDate) { this.checkInDate = checkInDate; }

        public java.time.LocalDate getCheckOutDate() { return checkOutDate; }
        public void setCheckOutDate(java.time.LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }
    }
}

