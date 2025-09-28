package com.example.stressly.controller

import com.example.stressly.service.RecursoService
import com.example.stressly.model.Recurso
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/recursos")
class RecursoController(
    private val recursoService: RecursoService
) {

    @GetMapping
    fun listarTodos(): ResponseEntity<List<Recurso>> =
        ResponseEntity.ok(recursoService.listarTodos())

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: String): ResponseEntity<Recurso> =
        ResponseEntity.ok(recursoService.buscarPorId(id))

    @GetMapping("/tipo/{tipo}")
    fun buscarPorTipo(@PathVariable tipo: String): ResponseEntity<List<Recurso>> =
        ResponseEntity.ok(recursoService.buscarPorTipo(tipo))

    @PostMapping
    fun salvar(@RequestBody recurso: Recurso): ResponseEntity<Recurso> =
        ResponseEntity.ok(recursoService.salvar(recurso))

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: String,
        @RequestBody recurso: Recurso
    ): ResponseEntity<Recurso> =
        ResponseEntity.ok(recursoService.atualizar(id, recurso))

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: String): ResponseEntity<Void> {
        recursoService.deletar(id)
        return ResponseEntity.noContent().build()
    }
}