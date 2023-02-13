package io.spring.shinyay.learningspringboot3.ch2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Chapter2Application

fun main(args: Array<String>) {
	runApplication<Chapter2Application>(*args)
}
