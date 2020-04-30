package com.example.demo

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class PostComment(
    @Id
    var id: Long,

    val review: String,

    @ManyToOne(fetch = FetchType.LAZY)
    val post: Post
)