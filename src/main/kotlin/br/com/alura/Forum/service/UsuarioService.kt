package br.com.alura.forum.service

import br.com.alura.Forum.model.Usuario
import java.util.*
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(id = 1, nome = "Ana da Silva", email = "ana@email.com.br")
        usuarios = Arrays.asList(usuario)
    }
    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter({ c -> c.id == id }).findFirst().get()
    }
}
