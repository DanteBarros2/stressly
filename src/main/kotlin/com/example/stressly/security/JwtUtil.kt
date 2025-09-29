package com.example.stressly.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {
    private val SECRET_KEY = "super_secret_key_stressly" // 🔒 troque em produção!

    fun generateToken(username: String): String {
        val claims: Map<String, Any> = HashMap()
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10h
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY.toByteArray())
            .compact()
    }

    fun extractUsername(token: String): String {
        return Jwts.parser()
            .setSigningKey(SECRET_KEY.toByteArray())
            .parseClaimsJws(token)
            .body
            .subject
    }

    fun validateToken(token: String, username: String): Boolean {
        return extractUsername(token) == username && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String): Boolean {
        val expiration = Jwts.parser()
            .setSigningKey(SECRET_KEY.toByteArray())
            .parseClaimsJws(token)
            .body
            .expiration
        return expiration.before(Date())
    }
}