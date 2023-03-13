package io.spring.shinyay.learningspringboot3.ch4.youtube.response

data class SearchSnippet(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnails: Map<String, SearchThumbnail>,
    val channelTitle: String
    )
