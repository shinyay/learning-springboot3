package io.spring.shinyay.learningspringboot3.ch4.youtube.response

data class SearchListResponse(
    val kind: String = "",
    val etag: String = "",
    val nextPageToken: String = "",
    val prevPageToken: String? = "",
    val pageInfo: PageInfo? = null,
    val items: Array<SearchResult>? = null
)
