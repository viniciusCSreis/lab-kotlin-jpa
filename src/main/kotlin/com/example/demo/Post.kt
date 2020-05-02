package com.example.demo

import javax.persistence.Access
import javax.persistence.AccessType
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Post (

    @Id
    @Access(AccessType.PROPERTY)
    var id: Long,

    val title: String,

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    var comments: MutableList<PostComment>
)