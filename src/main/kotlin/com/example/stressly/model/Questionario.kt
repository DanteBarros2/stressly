package com.example.stressly.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "questionarios")
data class Questionario(
    @Id val id: String? = null,
    val usuarioId: String, // referência ao usuário que respondeu
    val respostas: Map<String, Int>,
    // exemplo: {"ansiedade"=3, "humor"=4, "sono"=2} (escala de 1 a 5)
    val dataResposta: LocalDateTime = LocalDateTime.now()
)