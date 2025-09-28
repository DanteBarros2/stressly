package com.example.stressly.service

import org.springframework.stereotype.Service
import com.example.stressly.model.Recurso
import com.example.stressly.repository.RecursoRepository
@Service
class RecursoService(
    private val recursoRepository: RecursoRepository
) {

    fun listarTodos(): List<Recurso> = recursoRepository.findAll()

    fun buscarPorId(id: String): Recurso =
        recursoRepository.findById(id).orElseThrow { RuntimeException("Recurso não encontrado") }

    fun buscarPorTipo(tipo: String): List<Recurso> =
        recursoRepository.findByTipo(tipo)

    fun salvar(recurso: Recurso): Recurso =
        recursoRepository.save(recurso)

    fun atualizar(id: String, recursoAtualizado: Recurso): Recurso {
        val recurso = buscarPorId(id)
        val novoRecurso = recurso.copy(
            titulo = recursoAtualizado.titulo,
            descricao = recursoAtualizado.descricao,
            tipo = recursoAtualizado.tipo,
            link = recursoAtualizado.link
        )
        return recursoRepository.save(novoRecurso)
    }

    fun deletar(id: String) {
        if (!recursoRepository.existsById(id)) {
            throw RuntimeException("Recurso não encontrado")
        }
        recursoRepository.deleteById(id)
    }
}