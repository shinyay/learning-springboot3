package io.spring.shinyay.learningspringboot3.ch2.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}

data class Video(val name: String)
