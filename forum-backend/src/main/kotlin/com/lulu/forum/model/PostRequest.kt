package com.lulu.forum.model

data class PostRequest(
    val titulo: String,
    val conteudo: String,
    val roomId: Long
)
