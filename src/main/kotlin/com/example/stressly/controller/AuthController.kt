package com.example.stressly.controller

import com.example.stressly.model.Account
import com.example.stressly.repository.AccountRepository
import com.example.stressly.security.CryptoUtil
import com.example.stressly.security.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

data class AuthRequest(val username: String, val password: String)
data class AuthResponse(val token: String)

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) {

    @PostMapping("/register")
    fun register(@RequestBody account: Account): ResponseEntity<Account> {
        val toSave = account.copy(
            username = CryptoUtil.encrypt(account.username),
            email    = CryptoUtil.encrypt(account.email),
            password = passwordEncoder.encode(account.password)
        )
        return ResponseEntity.ok(accountRepository.save(toSave))
    }


    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {
        val encryptedUsername = CryptoUtil.encrypt(request.username)

        val account = accountRepository.findByUsername(encryptedUsername)
            ?: return ResponseEntity.status(401).build()

        if (!passwordEncoder.matches(request.password, account.password)) {
            return ResponseEntity.status(401).build()
        }

        val token = jwtUtil.generateToken(request.username) // token guarda o username em texto claro
        return ResponseEntity.ok(AuthResponse(token))
    }
}
