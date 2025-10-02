package com.example.stressly.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "relatorios_humor")
data class RelatorioHumor(
    @Id
    val id: String? = null,
    val usuarioId: String,
    val totalQuestionarios: Int,
    val emojiMaisFrequente: String?,
    val sentimentoMaisFrequente: String?,
    val mediaCargaTrabalho: Double,
    val mediaRelChefe: Double,
    val mediaRelColegas: Double
)
