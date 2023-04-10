package io.spring.shinyay.learningspringboot3.ch6

import io.spring.shinyay.learningspringboot3.ch6.video.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AppConfig::class)
class Chapter6Application

fun main(args: Array<String>) {
	runApplication<Chapter6Application>(*args)
}
