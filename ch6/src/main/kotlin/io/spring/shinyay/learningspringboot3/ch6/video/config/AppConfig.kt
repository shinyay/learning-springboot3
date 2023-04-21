package io.spring.shinyay.learningspringboot3.ch6.video.config

import io.spring.shinyay.learningspringboot3.ch6.security.entity.UserAccount
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app.config")
data class AppConfig (
    val header: String,
    val intro: String,
    val users: MutableList<UserAccount>
)
