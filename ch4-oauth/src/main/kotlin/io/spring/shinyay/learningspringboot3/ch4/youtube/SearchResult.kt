package io.spring.shinyay.learningspringboot3.ch4.youtube

data class SearchResult(val kind: String,
                        val etag: String,
                        val id: SearchId,
                        val snippet: SearchSnippet)
