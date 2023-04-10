package io.spring.shinyay.learningspringboot3.ch6.video.controller

import io.spring.shinyay.learningspringboot3.ch6.video.dto.NewVideo
import io.spring.shinyay.learningspringboot3.ch6.video.dto.Search
import io.spring.shinyay.learningspringboot3.ch6.video.service.VideoService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@Controller
class HomeController(val videoService: VideoService) {

    @GetMapping("/")
    fun index(model: Model, authentication: Authentication): String {
        model.addAttribute("videos", videoService.getVideos())
        model.addAttribute("authentication", authentication)

        return "index"
    }

    @PostMapping("/new-video")
    fun newVideo(@ModelAttribute video: NewVideo, authentication: Authentication): String {
        videoService.create(video, authentication.name)
        return "redirect:/"
    }

    @PostMapping("/search")
    fun universalSearch(@ModelAttribute search: Search, model: Model): String {
        val searchResults = videoService.search(search)
        model.addAttribute("videos", searchResults)
        return "index"
    }

    @PostMapping("/delete/videos/{videoId}")
    fun deleteVideo(@PathVariable videoId: Long): String? {
        videoService.delete(videoId)
        return "redirect:/"
    }
}
