package com.example.stressly.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "checkins_humor")
data class CheckInHumor(
    @Id
    val id: String? = null,
    val accountId: String, // vínculo com o usuário logado
    val sentimento: String, // Alegre, Cansado, Ansioso, Medroso, Raivoso
    val dataRegistro: LocalDateTime = LocalDateTime.now()
)
