package com.example.stressly.controller

import com.example.stressly.dto.CheckInHumorRequest
import com.example.stressly.model.CheckInHumor
import com.example.stressly.service.CheckInHumorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/checkin")
class CheckInHumorController(
    private val checkInHumorService: CheckInHumorService
) {

    @PostMapping
    fun registrar(@RequestBody request: CheckInHumorRequest, principal: Principal): ResponseEntity<CheckInHumor> {
        val checkIn = CheckInHumor(
            id = null,
            accountId = principal.name, // pega do usuário logado (JWT)
            estadoAtual = request.estadoAtual,
            dataRegistro = LocalDateTime.now()
        )
        val salvo = checkInHumorService.registrar(checkIn)
        return ResponseEntity.ok(salvo)
    }

    @GetMapping
    fun listarPorUsuario(principal: Principal): ResponseEntity<List<CheckInHumor>> {
        return ResponseEntity.ok(checkInHumorService.listarPorAccount(principal.name))
    }
}
