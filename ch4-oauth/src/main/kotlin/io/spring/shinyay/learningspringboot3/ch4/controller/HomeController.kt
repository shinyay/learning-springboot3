package io.spring.shinyay.learningspringboot3.ch4.controller

import io.spring.shinyay.learningspringboot3.ch4.youtube.YouTube
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HomeController(private val youTube: YouTube) {
    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute(
            "channelVideos",  //
            youTube.channelVideos(
                "UCjukbYOd6pjrMpNMFAOKYyw",  //
                10, YouTube.Sort.VIEW_COUNT
            )
        )
        return "index"
    }
}
