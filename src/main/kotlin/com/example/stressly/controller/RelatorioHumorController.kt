package com.example.stressly.controller

import com.example.stressly.model.RelatorioHumor
import com.example.stressly.service.RelatorioHumorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/relatorios/humor")
class RelatorioHumorController(
    private val relatorioHumorService: RelatorioHumorService
) {

    @PostMapping("/gerar")
    fun gerarRelatorio(principal: Principal): ResponseEntity<RelatorioHumor> =
        ResponseEntity.ok(relatorioHumorService.gerarRelatorio(principal.name))

    @GetMapping
    fun listarRelatorios(principal: Principal): ResponseEntity<List<RelatorioHumor>> =
        ResponseEntity.ok(relatorioHumorService.listarRelatorios(principal.name))
}
