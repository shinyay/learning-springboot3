package io.spring.shinyay.learningspringboot3.ch5.video.service

import io.spring.shinyay.learningspringboot3.ch5.video.repository.VideoRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
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
}
