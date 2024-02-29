package br.com.alura.Forum.model

data class NovoTopicoForm (
        val titulo: String,
        val mensagem: String,
        val idCurso: Long,
        val idAutor: Long
) 