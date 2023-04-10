package io.spring.shinyay.learningspringboot3.ch5.video.config

import io.spring.shinyay.learningspringboot3.ch5.security.entity.UserAccount

data class AppConfig (
    val header: String,
    val intro: String,
    val list: MutableList<UserAccount>
)
