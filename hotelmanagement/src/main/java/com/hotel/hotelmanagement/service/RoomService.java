package com.hotel.hotelmanagement.service;

import com.hotel.hotelmanagement.model.Room;
import com.hotel.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(int id, Room updatedRoom) {
        Room room = getRoomById(id);
        if (room != null) {
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setType(updatedRoom.getType());
            room.setPrice(updatedRoom.getPrice());
            room.setStatus(updatedRoom.getStatus());
            return roomRepository.save(room);
        }
        return null;
    }

    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }
}


