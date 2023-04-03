package io.spring.shinyay.learningspringboot3.ch5.video.repository

import io.spring.shinyay.learningspringboot3.ch5.video.entity.VideoEntity
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
class VideoRepositoryHsqlTest(val repository: VideoRepository) {

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
}
