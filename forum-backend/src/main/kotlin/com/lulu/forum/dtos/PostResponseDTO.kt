package com.lulu.forum.dtos

import com.lulu.forum.model.Room

data class PostResponseDTO(
    val id: Long,
    val titulo: String,
    val conteudo: String,
    val room: Room,
)
