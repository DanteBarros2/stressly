package com.example.stressly.repository

import com.example.stressly.model.Questionario
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionarioRepository : MongoRepository<Questionario, String> {
    fun findByUsuarioId(usuarioId: String): List<Questionario>
}