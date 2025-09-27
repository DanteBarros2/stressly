package com.example.stressly

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/accounts")
class AccountController(val repository: AccountRepository) {

    @PostMapping
    fun create(@RequestBody account: Account): ResponseEntity<Account> = ResponseEntity.ok(repository.save(account))

    @GetMapping
    fun read() : ResponseEntity<List<Account>> = ResponseEntity.ok(repository.findAll())

    @PutMapping("{document}")
    fun update(@PathVariable document: String, @RequestBody account: Account): ResponseEntity<Account> {
        val accountDBOptional = repository.findByDocument(document)
        val accountDB = accountDBOptional.orElseThrow { RuntimeException("Account document: $document not found!") }
        val saved = repository.save(accountDB.copy(name = accountDB.name,  state = null))
        return ResponseEntity.ok(saved)
    }

    @DeleteMapping("{document}")
    fun delete(@PathVariable document: String): Unit = repository
        .findByDocument(document)
        .ifPresent { repository.delete(it) }
}