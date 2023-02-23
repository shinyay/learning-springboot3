package io.spring.shinyay.learningspringboot3.ch3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Chapter3Application

fun main(args: Array<String>) {
	runApplication<Chapter3Application>(*args)
}
