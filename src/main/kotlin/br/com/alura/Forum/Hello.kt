package br.com.alura.Forum

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/hello")
class Hello {

    @GetMapping
    fun hello(): String {
        return "hello word!"
    }
}
