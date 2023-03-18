package io.spring.shinyay.learningspringboot3.ch5.video.controller

import io.spring.shinyay.learningspringboot3.ch5.video.dto.UniversalSearch
import io.spring.shinyay.learningspringboot3.ch5.video.dto.VideoSearch
import io.spring.shinyay.learningspringboot3.ch5.video.dto.NewVideo
import io.spring.shinyay.learningspringboot3.ch5.video.entity.VideoEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import io.spring.shinyay.learningspringboot3.ch5.video.service.VideoService

@Controller
class HomeController(val videoService: VideoService) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("videos", videoService.getVideos())
        return "index"
    }

    @PostMapping("/new-video")
    fun newVideo(@ModelAttribute video: NewVideo): String {
        videoService.create(video)
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
}
