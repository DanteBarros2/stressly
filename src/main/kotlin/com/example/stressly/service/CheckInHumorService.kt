package com.example.stressly.service

import com.example.stressly.model.CheckInHumor
import com.example.stressly.repository.CheckInHumorRepository
import org.springframework.stereotype.Service

@Service
class CheckInHumorService(
    private val checkInHumorRepository: CheckInHumorRepository
) {
    fun registrar(checkIn: CheckInHumor): CheckInHumor =
        checkInHumorRepository.save(checkIn)

    fun listarPorAccount(accountId: String): List<CheckInHumor> =
        checkInHumorRepository.findByAccountId(accountId)

    fun listarTodos(): List<CheckInHumor> =
        checkInHumorRepository.findAll()
}