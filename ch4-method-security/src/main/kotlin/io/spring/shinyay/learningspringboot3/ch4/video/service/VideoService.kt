package io.spring.shinyay.learningspringboot3.ch4.video.service

import io.spring.shinyay.learningspringboot3.ch4.video.dto.NewVideo
import io.spring.shinyay.learningspringboot3.ch4.video.dto.UniversalSearch
import io.spring.shinyay.learningspringboot3.ch4.video.dto.VideoSearch
import io.spring.shinyay.learningspringboot3.ch4.video.entity.VideoEntity
import io.spring.shinyay.learningspringboot3.ch4.video.repository.VideoRepository
import jakarta.annotation.PostConstruct
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher.StringMatcher
import org.springframework.data.domain.ExampleMatcher.matchingAny
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.util.*
import java.util.function.Function


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

    fun create(newVideo: NewVideo, username: String): VideoEntity? = repository.saveAndFlush(
        VideoEntity(username, newVideo.name, newVideo.description)
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

    fun delete(videoId: Long) {
        repository.findById(videoId)
            .map<Boolean>(Function { videoEntity: VideoEntity? ->
                repository.delete(videoEntity!!)
                true
            })
            .orElseThrow {
                RuntimeException(
                    "No video at $videoId"
                )
            }
    }

}
