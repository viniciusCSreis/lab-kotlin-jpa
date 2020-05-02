package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    private val postCommentRepository: PostCommentRepository
) {

    @GetMapping("/search")
    fun search(): String {
        val result = postCommentRepository.findAll()
        return "size:${result.size}"

    }

    @GetMapping("/join")
    fun join(): String {
        val result = postCommentRepository.findAll()
        val posts = result.map { it.post.id }.joinToString(",")
        return "size:${result.size} posts:$posts"

    }

    @GetMapping("/eager")
    fun eager(): String {
        val result = postCommentRepository.findAll()
        val posts = result.joinToString(",") { it.post.title }
        return "size:${result.size} posts:$posts"

    }
}