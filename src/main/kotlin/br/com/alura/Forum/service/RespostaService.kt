package br.com.alura.forum.service

import br.com.alura.Forum.model.Curso
import br.com.alura.Forum.model.Resposta
import br.com.alura.Forum.model.Topico
import br.com.alura.Forum.model.Usuario
import java.util.*
import java.util.stream.Collectors
import org.springframework.stereotype.Service

@Service
class RespostaService(private var respostas: List<Resposta>) {

    init {
        val curso = Curso(id = 1, nome = "Kotlin", categoria = "Programacao")
        val autor = Usuario(id = 1, nome = "Ana da Silva", email = "ana@email.com")
        val topico =
                Topico(
                        id = 1,
                        titulo = "Duvida Kotlin",
                        mensagem = "Variaveis no Kotlin",
                        curso = curso,
                        autor = autor
                )

        val resposta =
                Resposta(
                        id = 1,
                        mensagem = "Resposta 1",
                        autor = autor,
                        topico = topico,
                        solucao = false
                )

        val resposta2 =
                Resposta(
                        id = 2,
                        mensagem = "Resposta 2",
                        autor = autor,
                        topico = topico,
                        solucao = false
                )

        respostas = Arrays.asList(resposta, resposta2)
    }

    fun listar(idTopico: Long): List<Resposta> {
        return respostas
                .stream()
                .filter { r -> r.topico.id == idTopico }
                .collect(Collectors.toList())
    }
}
