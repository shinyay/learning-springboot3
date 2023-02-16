package io.spring.shinyay.learningspringboot3.ch2.controller

import io.spring.shinyay.learningspringboot3.ch2.entity.Video
import io.spring.shinyay.learningspringboot3.ch2.service.VideoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HomeController(val videoService: VideoService) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("videos", videoService.getVideos())
        return "index"
    }

    @PostMapping("/new-video")
    fun newVideo(video: Video): String {
        videoService.create(video)
        return "redirect:/"
    }
}
