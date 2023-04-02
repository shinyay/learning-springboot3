package io.spring.shinyay.learningspringboot3.ch5.video.service

import io.spring.shinyay.learningspringboot3.ch5.video.dto.NewVideo
import io.spring.shinyay.learningspringboot3.ch5.video.entity.VideoEntity
import io.spring.shinyay.learningspringboot3.ch5.video.repository.VideoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class VideoServiceTest {

    lateinit var service: VideoService

    @Mock
    lateinit var repository: VideoRepository

    @BeforeEach
    fun setUp() {
        service = VideoService(repository)
    }

    @Test
    fun getVideosShouldReturnAll() {
        // given
        val video1 = VideoEntity("alice", "Spring Boot 3 Intro", "Learn the basics!")
        val video2 = VideoEntity("alice", "Spring Boot 3 Deep Dive", "Go deep!")
        `when`(repository.findAll()).thenReturn(listOf(video1, video2))

        // when
        val videos = service.getVideos()

        // then
        assertThat(videos).containsExactly(video1, video2)
    }

    @Test
    fun creatingANewVideoShouldReturnTheSameData() {
        // given
        given(repository.saveAndFlush(any(VideoEntity::class.java)))
            .willReturn(VideoEntity("alice", "name", "description"))

        // when
        val newVideo = service.create(NewVideo("name", "description"), "alice")

        // then
        assertThat(newVideo!!.name).isEqualTo("name")
        assertThat(newVideo.description).isEqualTo("description")
        assertThat(newVideo.username).isEqualTo("alice")
    }
}
