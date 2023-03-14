package io.spring.shinyay.learningspringboot3.ch4.youtube.response

data class SearchResult(
    val kind: String = "",
    val etag: String = "",
    val id: SearchId? = null,
    val snippet: SearchSnippet? = null
)

