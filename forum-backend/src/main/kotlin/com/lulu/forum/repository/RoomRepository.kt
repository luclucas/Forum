package com.lulu.forum.repository

import com.lulu.forum.model.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository: JpaRepository<Room, Long> {
}