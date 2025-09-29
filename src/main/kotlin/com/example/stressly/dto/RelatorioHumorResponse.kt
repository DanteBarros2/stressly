package com.example.stressly.dto

data class RelatorioHumorResponse(
    val nivelEstresse: String,
    val principaisSintomas: List<String>,
    val riscoBurnout: String,
    val recomendacoes: List<String>
)