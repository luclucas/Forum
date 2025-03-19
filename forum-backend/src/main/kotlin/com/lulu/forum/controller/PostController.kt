package com.lulu.forum.controller

import com.lulu.forum.dtos.PostResponseDTO
import com.lulu.forum.dtos.PostTitleDTO
import com.lulu.forum.model.Post
import com.lulu.forum.model.PostRequest
import com.lulu.forum.repository.PostRepository
import com.lulu.forum.repository.RoomRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/rooms/{roomId}/posts")
class PostController(
    private val postRepository: PostRepository,
    private val roomRepository: RoomRepository
) {


    @PostMapping()
    fun createPost(@PathVariable roomId: Long, @RequestBody postRequest: PostRequest): ResponseEntity<PostResponseDTO> {
        val room = roomRepository.findById(postRequest.roomId).orElseThrow{ RuntimeException("Room not found") }
        val post = Post(titulo = postRequest.titulo, conteudo = postRequest.conteudo, room = room)
        val savedPost = postRepository.save(post)

        val response = PostResponseDTO(savedPost.id, savedPost.titulo, savedPost.conteudo, savedPost.room)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("")
    fun getPostsByRoom(@PathVariable roomId: Long): ResponseEntity<List<PostTitleDTO>> {
        val posts = postRepository.findByRoom(roomId)
        val postsDTO = posts.map { p->
            PostTitleDTO(p.id, p.titulo)
        }
        return ResponseEntity.ok(postsDTO)
    }

    @GetMapping("/all")
    fun getAllPosts(): ResponseEntity<List<Post>> {
        val posts = postRepository.findAll()
        return ResponseEntity.ok(posts)
    }
}