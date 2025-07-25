package com.hotel.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotelmanagement.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    // You can add custom queries here later if needed
}
