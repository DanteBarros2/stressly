package com.example.stressly.repository

import com.example.stressly.model.Account
import org.springframework.data.mongodb.repository.MongoRepository

interface AccountRepository : MongoRepository<Account, String> {
    fun findByUsername(username: String): Account?
}