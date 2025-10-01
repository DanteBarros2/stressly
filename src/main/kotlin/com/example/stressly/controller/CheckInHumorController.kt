package com.example.stressly.controller

import com.example.stressly.model.CheckInHumor
import com.example.stressly.service.CheckInHumorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/checkin")
class CheckInHumorController(
    private val checkInHumorService: CheckInHumorService
) {
    @PostMapping
    fun registrar(@RequestBody checkIn: CheckInHumor): ResponseEntity<CheckInHumor> {
        val salvo = checkInHumorService.registrar(checkIn)
        return ResponseEntity.ok(salvo)
    }

    @GetMapping("/account/{accountId}")
    fun listarPorAccount(@PathVariable accountId: String): ResponseEntity<List<CheckInHumor>> {
        return ResponseEntity.ok(checkInHumorService.listarPorAccount(accountId))
    }

    @GetMapping
    fun listarTodos(): ResponseEntity<List<CheckInHumor>> {
        return ResponseEntity.ok(checkInHumorService.listarTodos())
    }
}