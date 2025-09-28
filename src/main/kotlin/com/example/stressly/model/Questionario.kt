package com.example.stressly.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime


@Document(collection = "questionarios")
data class Questionario(
    @Id val id: String? = null,
    val usuarioId: String,

    // Perguntas
    val emojiDia: String, // Triste, Alegre, Cansado, Ansioso, Medo, Raiva
    val comoSeSente: String, // Motivado, Cansado, Preocupado, Estressado, Animado, Satisfeito
    val cargaTrabalho: String, // Muito Leve, Leve, Média, Alta, Muito Alta
    val cargaAfetaVida: String, // Não, Raramente, Às vezes, Frequentemente, Sempre
    val trabalhaForaHorario: String, // Não, Raramente, Às vezes, Frequentemente, Sempre
    val sintomas: String, // Nunca, Raramente, Às vezes, Frequentemente, Sempre
    val saudeMentalAfetaProdutividade: String, // Nunca, Raramente, Às vezes, Frequentemente, Sempre

    // Relacionamento com liderança e colegas (escala de 1 a 5)
    val relChefe: Int,
    val relColegas: Int,
    val respeitoColegas: Int,
    val relacionamentoSaudavelEquipe: Int,
    val liberdadeExpressarOpinioes: Int,
    val sentirAcolhidoTime: Int,
    val espiritoCooperacao: Int,
    val orientacoesClaras: Int,
    val comunicacaoComLideranca: Int,
    val circulacaoInformacoes: Int,
    val clarezaMetas: Int,
    val liderancaBemEstar: Int,
    val liderancaDisponivel: Int,
    val confortoReportarProblemas: Int,
    val reconhecimentoEsforcos: Int,
    val confiancaTransparencia: Int,

    val dataResposta: LocalDateTime = LocalDateTime.now()
)