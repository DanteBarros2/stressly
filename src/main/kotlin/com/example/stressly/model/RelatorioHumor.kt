package com.example.stressly.model


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "relatorios_humor")
data class RelatorioHumor(
    @Id val id: String? = null,
    val usuarioId: String,

    // Dados consolidados
    val totalQuestionarios: Int,
    val emojiMaisFrequente: String?,
    val sentimentoMaisFrequente: String?,
    val mediaCargaTrabalho: Double,
    val mediaRelChefe: Double,
    val mediaRelColegas: Double,

    val geradoEm: LocalDateTime = LocalDateTime.now()
)