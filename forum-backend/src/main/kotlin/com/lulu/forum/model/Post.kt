package com.lulu.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "posts")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @Column(nullable = false)
    var titulo: String,
    @Column(nullable = false, columnDefinition = "TEXT")
    var conteudo: String,

    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "room_id")
    val room: Room

    )