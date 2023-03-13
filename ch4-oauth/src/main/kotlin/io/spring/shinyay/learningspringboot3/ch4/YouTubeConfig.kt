package io.spring.shinyay.learningspringboot3.ch4

import org.springframework.context.annotation.Configuration

@Configuration
class YouTubeConfig {

    companion object {
        const val YOUTUBE_V3_API = "https://www.googleapis.com/youtube/v3"
    }
}
