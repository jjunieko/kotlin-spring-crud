package br.com.alura.forum.service

import br.com.alura.Forum.model.Curso
import java.util.*
import org.springframework.stereotype.Service

@Service
class CursoService(var cursos: List<Curso>) {
    init {
        val curso = Curso(id = 1, nome = "Kotlin", categoria = "Programacao")
        cursos = Arrays.asList(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter({
            c -> c.id == id
        }).findFirst().get()
}
}
