package com.example.demo

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity(name = "PostComment")
@Table(name = "post_comment")
data class PostComment(
    @Id
    private var id: Long? = null,

    private val review: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    private val post: Post? = null
)