package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication{

	val log = LoggerFactory.getLogger("Classe de teste")

	@Bean
	fun demo(
		postRepository: PostRepository,
		postCommentRepository: PostCommentRepository
	): CommandLineRunner? {
		return CommandLineRunner { args: Array<String?>? ->
			log.info("Inserting Post and comment...")
			log.info("-------------------------------")
			val comment1 = PostComment(1L,"Comment 1")
			val post = Post(1L,"Post 1", listOf(comment1) )
			postRepository.save(post)
			log.info("")

			// fetch all customers
			log.info("PostComments found with findAll():")
			log.info("-------------------------------")
			for (c in postCommentRepository.findAll()) {
				log.info(c.toString())
			}
			log.info("")

			// fetch an individual comment by ID
			val comment = postCommentRepository.findOne(1L)
			log.info("PostComment found with findById(1L):")
			log.info("--------------------------------")
			log.info(comment.toString())
			log.info("")
		}
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(DemoApplication::class, *args)
}