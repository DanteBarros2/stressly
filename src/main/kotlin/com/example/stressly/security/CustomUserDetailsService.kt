package com.example.stressly.security

import com.example.stressly.repository.AccountRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val accountRepository: AccountRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val encryptedUsername = CryptoUtil.encrypt(username)

        val account = accountRepository.findByUsername(encryptedUsername)
            ?: throw UsernameNotFoundException("Conta não encontrada: $username")

        return User(username, account.password, emptyList())
    }
}
