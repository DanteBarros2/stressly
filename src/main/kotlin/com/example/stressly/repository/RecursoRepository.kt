package com.example.stressly.repository

import com.example.stressly.model.Recurso
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RecursoRepository : MongoRepository<Recurso, String> {
    fun findByTipo(tipo: String): List<Recurso>
}