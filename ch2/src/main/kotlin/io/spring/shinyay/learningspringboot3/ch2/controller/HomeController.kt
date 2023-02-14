package io.spring.shinyay.learningspringboot3.ch2.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    val videos = mutableListOf<Video>(
        Video("Spring Boot 3 in Action"),
        Video("Spring Framework 6 in Action"),
        Video("Spring Cloud in Action")
    )

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}

data class Video(val name: String)
