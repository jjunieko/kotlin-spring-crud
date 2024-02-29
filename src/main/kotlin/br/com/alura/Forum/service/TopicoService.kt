package br.com.alura.forum.service

import br.com.alura.Forum.model.NovoTopicoForm
import br.com.alura.Forum.model.Topico
import br.com.alura.Forum.model.TopicoView
import java.util.*
import java.util.stream.Collectors
import org.springframework.stereotype.Service

@Service
class TopicoService(
        private var topicos: List<Topico> = ArrayList(),
        private val cursoService: CursoService,
        private val usuarioService: UsuarioService
) {

    // init{
    //     val topico = Topico(
    //         id = 1,
    //         titulo = "Duvida Kotlin",
    //         mensagem = "Variaveis no Kotlin",
    //         curso = Curso (
    //             id = 1,
    //             nome = "Kotlin",
    //             categoria = "programacao"
    //        ),
    //        autor = Usuario(
    //            id = 1,
    //            nome = "Ana da Silva",
    //            email = "ana@email.com"
    //        )
    //    )
    //    val topico2 = Topico(
    //          id = 2,
    //          titulo = "Duvida Kotlin 2",
    //          mensagem = "Variaveis no Kotlin",
    //          curso = Curso (
    //              id = 1,
    //              nome = "Kotlin",
    //              categoria = "programacao"
    //         ),
    //         autor = Usuario(
    //             id = 1,
    //             nome = "Ana da Silva",
    //             email = "ana@email.com"
    //         )
    //     )
    //     val topico3 = Topico(
    //          id = 3,
    //          titulo = "Duvida Kotlin 3",
    //          mensagem = "Variaveis no Kotlin",
    //          curso = Curso (
    //              id = 1,
    //              nome = "Kotlin",
    //              categoria = "programacao"
    //         ),
    //         autor = Usuario(
    //             id = 1,
    //             nome = "Ana da Silva",
    //             email = "ana@email.com"
    //         )
    //     )
    //     topicos =  Arrays.asList(topico, topico2, topico3)
    // }

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t -> TopicoView(
                id = t.id,
                titulo = t.titulo,
                mensagem = t.mensagem,
                dataCriacao = t.dataCriacao,
                status = t.status
        ) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({ t -> t.id == id }).findFirst().get()
    }

    fun cadastrar(dto: NovoTopicoForm) {
        topicos =
                topicos.plus(
                        Topico(
                                id = topicos.size.toLong() + 1,
                                titulo = dto.titulo,
                                mensagem = dto.mensagem,
                                curso = cursoService.buscarPorId(dto.idCurso),
                                autor = usuarioService.buscarPorId(dto.idAutor)
                        )
                )
    }
}
