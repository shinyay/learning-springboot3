package io.spring.shinyay.learningspringboot3.ch5.video.controller

import io.spring.shinyay.learningspringboot3.ch5.video.service.VideoService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get


@WebMvcTest(controllers = [HomeController::class])
class HomeControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var videoService: VideoService

    @Test
    fun indexPageHasSeveralHtmlFroms() {
        val html = mvc.perform(
            get("/")
        )
    }
}
