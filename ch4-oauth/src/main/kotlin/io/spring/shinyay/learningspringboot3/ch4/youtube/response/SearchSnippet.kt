package io.spring.shinyay.learningspringboot3.ch4.youtube.response

data class SearchSnippet(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnails: Map<String, SearchThumbnail>,
    val channelTitle: String
    ) {
    fun shortDescription(): String? {
        return if (description.length <= 100) {
            description
        } else description.substring(0, 100)
    }

    fun thumbnail_temp(): SearchThumbnail? {
        return thumbnails.entries.stream()
            .filter { entry -> entry.key.equals(("default")) }
            .findFirst()
            .map { it.value }
            .orElse(null) as SearchThumbnail?
    }
}
