package service

import dto.UniversalSearch
import dto.VideoSearch
import dto.NewVideo
import entity.VideoEntity
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher.StringMatcher
import org.springframework.data.domain.ExampleMatcher.matchingAny
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import repository.VideoRepository
import java.util.*


@Service
class VideoService(val repository: VideoRepository) {

    private var videos: MutableList<NewVideo> = mutableListOf(
        NewVideo("Learning Spring Boot 3", ""),
        NewVideo("Spring Boot 3 in Action", ""),
        NewVideo("Spring Framework 6 in Action", ""),
        NewVideo("Spring Cloud in Action", ""),
    )

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
            matchingAny().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING)
        )
        return repository.findAll(example)
    }
}
