package io.spring.shinyay.learningspringboot3.ch2.service

import io.spring.shinyay.learningspringboot3.ch2.entity.Video
import org.springframework.stereotype.Service

@Service
class VideoService {

    val videos: List<Video> = mutableListOf(
        Video("Learning Spring Boot 3"),
        Video("Spring Boot 3 in Action"),
        Video("Spring Framework 6 in Action"),
        Video("Spring Cloud in Action"),
    )

    fun getVideos(): List<Video> {
        return videos;
    }
}
