package com.example.stressly.controller


import com.example.stressly.model.Questionario
import com.example.stressly.service.QuestionarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/questionarios")
class QuestionarioController(
    private val questionarioService: QuestionarioService
) {

    @GetMapping
    fun listarTodos(): ResponseEntity<List<Questionario>> =
        ResponseEntity.ok(questionarioService.listarTodos())

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: String): ResponseEntity<Questionario> =
        ResponseEntity.ok(questionarioService.buscarPorId(id))

    @GetMapping("/usuario/{usuarioId}")
    fun buscarPorUsuario(@PathVariable usuarioId: String): ResponseEntity<List<Questionario>> =
        ResponseEntity.ok(questionarioService.buscarPorUsuario(usuarioId))

    @PostMapping
    fun salvar(@RequestBody questionario: Questionario): ResponseEntity<Questionario> =
        ResponseEntity.ok(questionarioService.salvar(questionario))

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: String,
        @RequestBody questionario: Questionario
    ): ResponseEntity<Questionario> =
        ResponseEntity.ok(questionarioService.atualizar(id, questionario))

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: String): ResponseEntity<Void> {
        questionarioService.deletar(id)
        return ResponseEntity.noContent().build()
    }
}
