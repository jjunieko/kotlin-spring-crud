package br.com.alura.Forum.model

import java.time.LocalDateTime
import br.com.alura.Forum.model.Topico
import br.com.alura.Forum.model.Usuario

data class Resposta (
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: Topico,
    val solucao: Boolean
)