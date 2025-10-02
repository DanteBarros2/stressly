package com.example.stressly.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "checkins")
data class CheckInHumor(
    @Id
    val id: String? = null,
    val accountId: String,
    val estadoAtual: String,
    val dataRegistro: LocalDateTime
)
