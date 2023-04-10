package io.spring.shinyay.learningspringboot3.ch5.video.repository

import io.spring.shinyay.learningspringboot3.ch5.video.entity.VideoEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ContextConfiguration(initializers = [VideoRepositoryTestcontainersTest.DataSourceInitializer::class])
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

        // Spring Boot 2.3.x
        // @DynamicPropertySource
        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", database::getJdbcUrl)
            registry.add("spring.datasource.name", database::getDatabaseName)
            registry.add("spring.datasource.username", database::getUsername)
            registry.add("spring.datasource.password", database::getPassword)
            registry.add("spring.jpa.hibernate.ddl-auto") {"create-drop"}
        }
    }

//    internal class DataSourceInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
// Spring Boot 2.x
//        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
//            TestPropertyValues.of(
//                "spring.datasource.url=" + database.jdbcUrl,
//                "spring.datasource.username=" + database.username,
//                "spring.datasource.password=" + database.password
//            ).applyTo(configurableApplicationContext.environment)
//        }

// Spring Boot 1.5.x
//        override fun initialize(applicationContext: ConfigurableApplicationContext) {
//            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
//                applicationContext,
//                "spring.datasource.url=" + database.jdbcUrl,
//                "spring.datasource.username=" + database.username,
//                "spring.datasource.password=" + database.password,
//                "spring.jpa.hibernate.ddl-auto=create-drop"
//            )
//        }
//    }

    @BeforeEach
    fun setUp() {
        repository.saveAll(
            listOf(
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
    fun findByName() {
        val videos = repository.findByNameContainsIgnoreCase("SPRING BOOT 3")
        assertThat(videos).hasSize(1)
    }

    @Test
    fun findByNameOrDescription() {
        val videos = repository.findByNameContainsOrDescriptionContainsAllIgnoreCase("CODE", "your code")
        assertThat(videos).hasSize(2)
    }

}
