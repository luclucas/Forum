package com.lulu.forum.controller

import com.lulu.forum.model.Room
import com.lulu.forum.repository.RoomRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/rooms")

class RoomController(private val roomRepository: RoomRepository) {

    @GetMapping
    fun getAllRooms(): ResponseEntity<List<Room>> {
        val rooms = roomRepository.findAll()
        return ResponseEntity.ok(rooms)
    }

    @PostMapping
    fun createRoom(@RequestBody body: Room): ResponseEntity<Room>{
        val room = roomRepository.save(body)
        return ResponseEntity.ok(room)
    }
}