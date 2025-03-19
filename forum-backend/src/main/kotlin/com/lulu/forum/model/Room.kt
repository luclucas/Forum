package com.lulu.forum.model

import jakarta.persistence.*

@Entity
@Table(name = "rooms")
data class Room(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column(nullable = false)
    var nome: String


)