package com.example.stressly.service

import com.example.stressly.model.Questionario
import com.example.stressly.repository.QuestionarioRepository
import org.springframework.stereotype.Service
@Service
class QuestionarioService(
    private val questionarioRepository: QuestionarioRepository
) {

    fun listarTodos(): List<Questionario> = questionarioRepository.findAll()

    fun buscarPorId(id: String): Questionario =
        questionarioRepository.findById(id)
            .orElseThrow { RuntimeException("Questionário não encontrado") }

    fun buscarPorUsuario(usuarioId: String): List<Questionario> =
        questionarioRepository.findByUsuarioId(usuarioId)

    fun salvar(questionario: Questionario): Questionario =
        questionarioRepository.save(questionario)

    fun atualizar(id: String, questionarioAtualizado: Questionario): Questionario {
        val existente = buscarPorId(id)
        val atualizado = questionarioAtualizado.copy(id = existente.id)
        return questionarioRepository.save(atualizado)
    }

    fun deletar(id: String) {
        if (!questionarioRepository.existsById(id)) {
            throw RuntimeException("Questionário não encontrado")
        }
        questionarioRepository.deleteById(id)
    }
}