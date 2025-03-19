package com.lulu.forum.repository

import com.lulu.forum.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PostRepository: JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.room.id = :roomId")
    fun findByRoom(@Param("roomId") roomId: Long): List<Post>
}