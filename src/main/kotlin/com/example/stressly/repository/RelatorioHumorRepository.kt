package com.example.stressly.repository


import com.example.stressly.model.RelatorioHumor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RelatorioHumorRepository : MongoRepository<RelatorioHumor, String> {
    fun findByUsuarioId(usuarioId: String): List<RelatorioHumor>
}