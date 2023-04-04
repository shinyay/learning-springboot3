package io.spring.shinyay.learningspringboot3.ch5.video.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.support.TestPropertySourceUtils
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
    companion object {
        @Container
        val database = PostgreSQLContainer<Nothing>("postgres:9.6.12").apply {
            withDatabaseName("testdb")
            withUsername("postgres")
        }
    }


    internal class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
            TestPropertyValues.of(
                "spring.datasource.url=" + database.jdbcUrl,
                "spring.datasource.username=" + database.username,
                "spring.datasource.password=" + database.password
            ).applyTo(configurableApplicationContext.environment)
        }

    }
}
