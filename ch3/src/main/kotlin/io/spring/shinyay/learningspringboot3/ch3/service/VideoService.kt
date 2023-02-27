package service

import dto.NewVideo
import dto.UniversalSearch
import dto.VideoSearch
import entity.VideoEntity
import jakarta.annotation.PostConstruct
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher.StringMatcher
import org.springframework.data.domain.ExampleMatcher.matchingAny
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import repository.VideoRepository
import java.util.*


@Service
class VideoService(val repository: VideoRepository) {

    @PostConstruct
    fun initDatabase() {
        repository.save(
            VideoEntity(
                "Learning Spring Boot 3",
                "Learn Spring Boot 3 with this book."
            )
        )
        repository.save(
            VideoEntity(
                "Learn how Spring Boot 3 works",
                ""
            )
        )
        repository.save(
            VideoEntity(
                "Spring Framework 6",
                "Learn how Spring Framework 6 works"
            )
        )
    }

    fun getVideos(): List<VideoEntity?> = repository.findAll()

    fun create(newVideo: NewVideo): VideoEntity? = repository.saveAndFlush(
        VideoEntity(newVideo.name, newVideo.description)
    )

    fun search(videoSearch: VideoSearch): List<VideoEntity>? {
        if (StringUtils.hasText(videoSearch.name)
            && StringUtils.hasText(videoSearch.description)) {
            return repository
                .findByNameContainsOrDescriptionContainsAllIgnoreCase(
                    videoSearch.name, videoSearch.description)
        }

        if (StringUtils.hasText(videoSearch.name)) {
            return repository.findByNameContainsIgnoreCase(videoSearch.name)
        }

        if (StringUtils.hasText(videoSearch.description)) {
            return repository.findByDescriptionContainsIgnoreCase(videoSearch.description)
        }

        return Collections.emptyList()
    }

    fun search(universalSearch: UniversalSearch): List<VideoEntity>? {
        val probe = VideoEntity()
        if (StringUtils.hasText(universalSearch.value)) {
            probe.name = universalSearch.value
            probe.description = universalSearch.value
        }
        val example: Example<VideoEntity> = Example.of(
            probe,
            matchingAny()
                .withIgnoreCase()
                .withStringMatcher(StringMatcher.CONTAINING)
        )
        return repository.findAll(example)
    }
}
