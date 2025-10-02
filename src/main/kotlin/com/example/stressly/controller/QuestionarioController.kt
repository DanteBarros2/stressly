package com.example.stressly.controller

import com.example.stressly.dto.QuestionarioRequest
import com.example.stressly.model.Questionario
import com.example.stressly.repository.QuestionarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/questionarios")
class QuestionarioController(
    private val questionarioRepository: QuestionarioRepository
) {

    @PostMapping
    fun criar(@RequestBody request: QuestionarioRequest, principal: Principal): ResponseEntity<Questionario> {
        val questionario = Questionario(
            usuarioId = principal.name, // pega do JWT
            emojiHoje = request.emojiHoje,
            sentimentoHoje = request.sentimentoHoje,
            cargaTrabalho = request.cargaTrabalho,
            cargaAfetaQualidadeVida = request.cargaAfetaQualidadeVida,
            trabalhaAlemHorario = request.trabalhaAlemHorario,
            sintomas = request.sintomas,
            saudeMentalAfetaProdutividade = request.saudeMentalAfetaProdutividade,
            relacionamentoChefe = request.relacionamentoChefe,
            relacionamentoColegas = request.relacionamentoColegas,
            respeitoColegas = request.respeitoColegas,
            relacionamentoEquipe = request.relacionamentoEquipe,
            liberdadeOpinioes = request.liberdadeOpinioes,
            acolhimentoTime = request.acolhimentoTime,
            cooperacaoColaboradores = request.cooperacaoColaboradores,
            orientacoesClaras = request.orientacoesClaras,
            comunicacaoLideranca = request.comunicacaoLideranca,
            circulacaoInformacoes = request.circulacaoInformacoes,
            clarezaMetas = request.clarezaMetas,
            liderancaBemEstar = request.liderancaBemEstar,
            liderancaDisponivel = request.liderancaDisponivel,
            confortoReportarProblemas = request.confortoReportarProblemas,
            reconhecimentoLideranca = request.reconhecimentoLideranca,
            confiancaTransparenciaLideranca = request.confiancaTransparenciaLideranca
        )
        return ResponseEntity.ok(questionarioRepository.save(questionario))
    }

    @GetMapping
    fun listar(principal: Principal): ResponseEntity<List<Questionario>> {
        return ResponseEntity.ok(questionarioRepository.findByUsuarioId(principal.name))
    }
}
