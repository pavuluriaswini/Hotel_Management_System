package com.hotel.hotelmanagement.controller;

import com.hotel.hotelmanagement.model.Room;
import com.hotel.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")  // Allows frontend access (for later)
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable int id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable int id) {
        roomService.deleteRoom(id);
    }
}

