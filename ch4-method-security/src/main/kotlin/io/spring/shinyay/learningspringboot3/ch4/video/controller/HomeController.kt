package io.spring.shinyay.learningspringboot3.ch4.video.controller

import io.spring.shinyay.learningspringboot3.ch4.video.dto.UniversalSearch
import io.spring.shinyay.learningspringboot3.ch4.video.dto.VideoSearch
import io.spring.shinyay.learningspringboot3.ch4.video.dto.NewVideo
import io.spring.shinyay.learningspringboot3.ch4.video.entity.VideoEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import io.spring.shinyay.learningspringboot3.ch4.video.service.VideoService
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PathVariable

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

//    @PostMapping("/multi-field-search")
//    fun multiFieldSearch(@ModelAttribute search: VideoSearch, model: Model): String {
//        val searchResult: List<VideoEntity>? = videoService.search(search)
//        model.addAttribute("videos", searchResult)
//        return "index"
//    }

//    @PostMapping("/universal-search")
    @PostMapping("/search")
    fun universalSearch(@ModelAttribute search: UniversalSearch, model: Model): String {
        val searchResults = videoService.search(search)
        model.addAttribute("videos", searchResults)
        return "index"
    }

    @PostMapping("/delete/videos/{videoId}")
    fun deleteVideo(@PathVariable videoId: Long): String {
        videoService.delete(videoId)
        return "redirect:/"
    }
}
