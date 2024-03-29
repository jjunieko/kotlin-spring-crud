package br.com.alura.Forum.model

import java.time.LocalDateTime
import br.com.alura.Forum.model.Curso
import br.com.alura.Forum.model.Usuario
import br.com.alura.Forum.model.Resposta
import br.com.alura.Forum.model.StatusTopico

data class Topico (
    val id: Long? = null,
    val titulo: `String`,
    val mensagem: `String`,
    val dataCriaclo: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)
