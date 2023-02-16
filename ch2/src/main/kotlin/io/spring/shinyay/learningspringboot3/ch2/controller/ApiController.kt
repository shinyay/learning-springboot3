package io.spring.shinyay.learningspringboot3.ch2.controller

import io.spring.shinyay.learningspringboot3.ch2.entity.Video
import io.spring.shinyay.learningspringboot3.ch2.service.VideoService
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(val videoService: VideoService) {

    fun all(): List<Video> = videoService.getVideos()
}
