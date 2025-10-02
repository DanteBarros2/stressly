package com.example.stressly.dto

data class QuestionarioRequest(
    val emojiHoje: String,
    val sentimentoHoje: String,
    val cargaTrabalho: String,
    val cargaAfetaQualidadeVida: String,
    val trabalhaAlemHorario: String,
    val sintomas: String,
    val saudeMentalAfetaProdutividade: String,
    val relacionamentoChefe: Int,
    val relacionamentoColegas: Int,
    val respeitoColegas: Int,
    val relacionamentoEquipe: Int,
    val liberdadeOpinioes: Int,
    val acolhimentoTime: Int,
    val cooperacaoColaboradores: Int,
    val orientacoesClaras: Int,
    val comunicacaoLideranca: Int,
    val circulacaoInformacoes: Int,
    val clarezaMetas: Int,
    val liderancaBemEstar: Int,
    val liderancaDisponivel: Int,
    val confortoReportarProblemas: Int,
    val reconhecimentoLideranca: Int,
    val confiancaTransparenciaLideranca: Int
)
