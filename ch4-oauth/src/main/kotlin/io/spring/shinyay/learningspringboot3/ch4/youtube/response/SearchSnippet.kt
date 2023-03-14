package io.spring.shinyay.learningspringboot3.ch4.youtube.response

import java.util.function.Function


@JvmRecord
data class SearchSnippet(
    val publishedAt: String = "",
    val channelId: String = "",
    val title: String = "",
    val description: String = "",
    val thumbnails: Map<String, SearchThumbnail>? = null,
    val channelTitle: String = ""
) {
    fun shortDescription(): String {
        return if (description.length <= 100) {
            description
        } else description.substring(0, 100)
    }

    fun thumbnail(): SearchThumbnail? {
        return thumbnails!!.entries.stream() //
            .filter { (key): Map.Entry<String, SearchThumbnail> -> key == "default" } //
            .findFirst() //
            .map { it.value } //
            .orElse(null)
    }
}
