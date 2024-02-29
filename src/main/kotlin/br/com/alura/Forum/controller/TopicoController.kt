package br.com.alura.Forum.controller


import br.com.alura.Forum.model.Usuario
import br.com.alura.Forum.model.Curso
import br.com.alura.Forum.model.Topico
import br.com.alura.Forum.model.NovoTopicoForm
import br.com.alura.Forum.model.TopicoView

import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
import jakarta.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return service.listar()
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t -> 
            t.id == id
        }.findFirst().get()
        return TopicoView(
                id = topico.id,
                titulo = topico.titulo,
                mensagem = topico.mensagem,
                dataCriacao = topico.dataCriacao,
                status = topico.status
        )
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm) {
    return service.cadastrar(dto)
    }

}