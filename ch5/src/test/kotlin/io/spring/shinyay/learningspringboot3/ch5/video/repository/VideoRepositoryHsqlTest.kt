package io.spring.shinyay.learningspringboot3.ch5.video.repository

import io.spring.shinyay.learningspringboot3.ch5.video.entity.VideoEntity
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
class VideoRepositoryHsqlTest(
    @Autowired
    val repository: VideoRepository
) {

//    @Autowired
//    lateinit var repository: VideoRepository

    @BeforeEach
    fun setUp() {
        repository.saveAll(
            mutableListOf(
                VideoEntity(
                    "alice",
                    "Need HELP with your SPRING BOOT 3 App?",
                    "SPRING BOOT 3 will only speed things up."
                ),
                VideoEntity(
                    "alice",
                    "Don't do THIS to your own CODE!",
                    "As a pro developer, never ever EVER do this to your code."
                ),
                VideoEntity(
                    "bob",
                    "SECRETS to fix BROKEN CODE!",
                    "Discover ways to not only debug your code"
                )
            )
        )
    }

    @Test
    fun findAllShouldProduceAllVideos() {
        val videos = repository.findAll()
        assertThat(videos).hasSize(3)
    }

    @Test
    fun findByNameShouldRetrieveOneEntry() {
        val videos = repository.findByNameContainsIgnoreCase("SpRinG bOOt 3")
        assertThat(videos).hasSize(1)
        assertThat(videos).extracting(VideoEntity::name)
            .containsExactlyInAnyOrder(
                Tuple.tuple("Need HELP with your SPRING BOOT 3 App?")
            )
    }
}
