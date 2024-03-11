package com.example.tasktwo.models

import java.util.UUID

data class Post(
    val id : String ? = UUID.randomUUID().toString(),
    val image : Int? = null
)
