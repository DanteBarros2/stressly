package com.example.stressly.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "recursos")
data class Recurso(
    @Id val id: String? = null,
    val titulo: String,
    val descricao: String,
    val tipo: String, // exemplo: "stress", "burnout", "sobrecarga"
    val link: String? = null // opcional, pode apontar para artigo/vídeo/etc
)