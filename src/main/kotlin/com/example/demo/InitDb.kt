package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InitDb {

    val log = LoggerFactory.getLogger("Classe de teste")

    @Bean
    fun init(
        postRepository: PostRepository,
        postCommentRepository: PostCommentRepository
    ): CommandLineRunner {
        return CommandLineRunner {
            postCommentRepository.deleteAllInBatch()
            postRepository.deleteAllInBatch()

            log.info("Inserting Post and comment...")
            log.info("-------------------------------")
            val post1 = Post(1L, "Post 1", emptyList())
            val comment1 = PostComment(1L, "Comment 1", post1)
            val comment2 = PostComment(2L, "Comment 2", post1)
            postRepository.save(post1)
            postCommentRepository.save(comment1)
            postCommentRepository.save(comment2)
            val post2 = Post(2L, "Post 2", emptyList())
            val comment3 = PostComment(3L, "Comment 3", post2)
            val comment4 = PostComment(4L, "Comment 4", post2)
            postRepository.save(post2)
            postCommentRepository.save(comment3)
            postCommentRepository.save(comment4)
            log.info("")
        }

    }
}