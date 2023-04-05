package io.spring.shinyay.learningspringboot3.ch5.video.controller

import io.spring.shinyay.learningspringboot3.ch5.video.service.VideoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest(controllers = [HomeController::class])
class SecurityBasedTest(
    @Autowired val mockMvc: MockMvc,
    @MockBean val videoService: VideoService) {
}
