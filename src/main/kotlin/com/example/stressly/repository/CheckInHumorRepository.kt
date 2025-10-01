package com.example.stressly.repository

import com.example.stressly.model.CheckInHumor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckInHumorRepository : MongoRepository<CheckInHumor, String> {
    fun findByAccountId(accountId: String): List<CheckInHumor>
}