package com.example.demo

import java.util.ArrayList
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity(name = "Post")
@Table(name = "post")
data class Post (

    @Id
    private val id: Long? = null,

    private val title: String? = null,

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    private val comments: List<PostComment> = ArrayList<PostComment>()
)