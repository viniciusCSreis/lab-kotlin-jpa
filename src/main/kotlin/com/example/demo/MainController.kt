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

}