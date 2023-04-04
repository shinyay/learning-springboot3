package io.spring.shinyay.learningspringboot3.ch5.video.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VideoRepositoryTestcontainersTest(
    @Autowired
    val repository: VideoRepository
) {
    @Container
    val database = PostgreSQLContainer<Nothing>("postgres:9.6.12").apply {
        withUsername("postgres")
    }

}
