package com.example.stressly.security

import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

object CryptoUtil {
    private const val ALGORITHM = "AES/GCM/NoPadding"
    private const val KEY = "12345678901234567890123456789012" // 32 chars -> AES-256
    private val secretKey: SecretKey = SecretKeySpec(KEY.toByteArray(), "AES")
    private val iv = ByteArray(12) { 0 } // ⚠️ exemplo simples -> em produção use IV aleatório

    fun encrypt(data: String): String {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, GCMParameterSpec(128, iv))
        val encrypted = cipher.doFinal(data.toByteArray())
        return Base64.getEncoder().encodeToString(encrypted)
    }

    fun decrypt(data: String): String {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, GCMParameterSpec(128, iv))
        val decoded = Base64.getDecoder().decode(data)
        return String(cipher.doFinal(decoded))
    }
}
