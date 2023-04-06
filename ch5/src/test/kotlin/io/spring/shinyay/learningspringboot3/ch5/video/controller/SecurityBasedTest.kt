package io.spring.shinyay.learningspringboot3.ch5.video.controller

import io.spring.shinyay.learningspringboot3.ch5.video.service.VideoService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(controllers = [HomeController::class])
class SecurityBasedTest @Autowired constructor(
    private val mockMvc: MockMvc,
    @MockBean val videoService: VideoService) {

    @Test
    fun unauthUserShouldNotAccessHomePage() {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isUnauthorized)
    }

    @Test
    @WithMockUser(username = "alice", roles = ["USER"])
    fun authUserShouldAccessHomePage() {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    @WithMockUser(username = "alice", roles = ["ADMIN"])
    fun adminUserShouldAccessHomePage() {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun newVideoFromUnauthUserShouldFail() {
        mockMvc
            .perform(MockMvcRequestBuilders.post("/new-video")
                .param("name", "new video")
                .param("description", "new description")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
            )
            .andExpect(MockMvcResultMatchers.status().isUnauthorized())
    }

    @Test
    @WithMockUser(username = "alice", roles = ["USER"])
    fun newVideoFromUserShouldWork() {
        mockMvc
            .perform(MockMvcRequestBuilders.post("/new-video")
                .param("name", "new video")
                .param("description", "new description")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
            )
            .andExpect(MockMvcResultMatchers.status().is3xxRedirection)
    }
}
