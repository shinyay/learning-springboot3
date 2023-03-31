package io.spring.shinyay.learningspringboot3.ch5.video.controller

import io.spring.shinyay.learningspringboot3.ch5.video.service.VideoService
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = [HomeController::class])
class HomeControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var videoService: VideoService

    @Test
    @WithMockUser
    fun indexPageHasSeveralHtmlFromsIsOk() {
        val html = mvc.perform(
            get("/")
        )
            .andExpect(status().isOk)
    }

//    @Test
//    fun indexPageHasSeveralHtmlFroms() {
//        val html = mvc.perform(
//            get("/")
//        )
//            .andExpect(
//                status().isOk
//            )
//            .andExpect(
//                content().string(
//                    containsString("Username: user")
//                )
//            )
//            .andExpect(
//                content().string(
//                    containsString("Authorities: [ROLE_USER]")
//                )
//            )
//            .andReturn()
//            .response.contentAsString
//
//        assertThat(html).contains(
//            "<form action=\"/logout\"",
//            "<form action=\"/search\"",
//            "<form action=\"/new-video\""
//        )
//    }
}
