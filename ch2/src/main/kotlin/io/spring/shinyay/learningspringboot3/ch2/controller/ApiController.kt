package io.spring.shinyay.learningspringboot3.ch2.controller

import io.spring.shinyay.learningspringboot3.ch2.entity.Video
import io.spring.shinyay.learningspringboot3.ch2.service.VideoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ApiController(val videoService: VideoService) {

    @GetMapping("/videos")
    fun all(): List<Video> = videoService.getVideos()

    @PostMapping("videos")
    fun newVideo(@RequestBody newVideo: Video) = videoService.create(newVideo)
}
