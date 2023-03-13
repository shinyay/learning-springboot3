package io.spring.shinyay.learningspringboot3.ch4.youtube.response

data class SearchId(val kind: String,
                    val videoId: String,
                    val channelId: String,
                    val playlistId: String)
