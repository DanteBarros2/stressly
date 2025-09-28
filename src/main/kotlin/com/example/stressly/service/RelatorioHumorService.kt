package com.example.stressly.service

import com.example.stressly.model.Questionario
import com.example.stressly.model.RelatorioHumor
import com.example.stressly.repository.QuestionarioRepository
import com.example.stressly.repository.RelatorioHumorRepository
import org.springframework.stereotype.Service

@Service
class RelatorioHumorService(
    private val questionarioRepository: QuestionarioRepository,
    private val relatorioHumorRepository: RelatorioHumorRepository
) {

    fun gerarRelatorio(usuarioId: String): RelatorioHumor {
        val questionarios: List<Questionario> = questionarioRepository.findByUsuarioId(usuarioId)

        if (questionarios.isEmpty()) {
            throw RuntimeException("Nenhum questionário encontrado para o usuário $usuarioId")
        }

        val total = questionarios.size

        // Emoji mais frequente
        val emojiMaisFrequente = questionarios.groupingBy { it.emojiDia }.eachCount()
            .maxByOrNull { it.value }?.key

        // Sentimento mais frequente
        val sentimentoMaisFrequente = questionarios.groupingBy { it.comoSeSente }.eachCount()
            .maxByOrNull { it.value }?.key

        // Médias (tratando escala de 1 a 5 como Int)
        val mediaCargaTrabalho = questionarios.map { cargaTrabalhoToScore(it.cargaTrabalho) }.average()
        val mediaRelChefe = questionarios.map { it.relChefe }.average()
        val mediaRelColegas = questionarios.map { it.relColegas }.average()

        val relatorio = RelatorioHumor(
            usuarioId = usuarioId,
            totalQuestionarios = total,
            emojiMaisFrequente = emojiMaisFrequente,
            sentimentoMaisFrequente = sentimentoMaisFrequente,
            mediaCargaTrabalho = mediaCargaTrabalho,
            mediaRelChefe = mediaRelChefe,
            mediaRelColegas = mediaRelColegas
        )

        return relatorioHumorRepository.save(relatorio)
    }

    fun listarRelatorios(usuarioId: String): List<RelatorioHumor> =
        relatorioHumorRepository.findByUsuarioId(usuarioId)

    private fun cargaTrabalhoToScore(carga: String): Int =
        when (carga) {
            "Muito Leve" -> 1
            "Leve" -> 2
            "Média" -> 3
            "Alta" -> 4
            "Muito Alta" -> 5
            else -> 3
        }
}