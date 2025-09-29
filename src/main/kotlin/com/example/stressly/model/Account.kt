package com.example.stressly.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "accounts")
data class Account(
    @Id
    val id: String? = null,
    val username: String,
    val email: String,
    var password: String, // será criptografada com BCrypt
    val role: String = "USER"
)