package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

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
            val post = Post(1L, "Post 1", emptyList())
            val comment1 = PostComment(1L, "Comment 1", post)
            postRepository.save(post)
            postCommentRepository.save(comment1)

            log.info("")
        }

    }
}