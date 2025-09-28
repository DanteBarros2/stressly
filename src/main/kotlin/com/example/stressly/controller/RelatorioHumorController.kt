package com.example.stressly.controller

import com.example.stressly.model.RelatorioHumor
import com.example.stressly.service.RelatorioHumorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/relatorios/humor")
class RelatorioHumorController(
    private val relatorioHumorService: RelatorioHumorService
) {

    @PostMapping("/{usuarioId}")
    fun gerarRelatorio(@PathVariable usuarioId: String): ResponseEntity<RelatorioHumor> =
        ResponseEntity.ok(relatorioHumorService.gerarRelatorio(usuarioId))

    @GetMapping("/{usuarioId}")
    fun listarRelatorios(@PathVariable usuarioId: String): ResponseEntity<List<RelatorioHumor>> =
        ResponseEntity.ok(relatorioHumorService.listarRelatorios(usuarioId))
}