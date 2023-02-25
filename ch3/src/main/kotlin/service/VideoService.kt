package service

import dto.VideoSearch
import entity.Video
import entity.VideoEntity
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import repository.VideoRepository
import java.util.*

@Service
class VideoService(val repository: VideoRepository) {

    private var videos: MutableList<Video> = mutableListOf(
        Video("Learning Spring Boot 3", ""),
        Video("Spring Boot 3 in Action", ""),
        Video("Spring Framework 6 in Action", ""),
        Video("Spring Cloud in Action", ""),
    )

    fun getVideos(): List<Video> = videos

    fun create(newVideo: Video): Video? {
        videos.add(newVideo)
        return newVideo
    }

    fun search(videoSearch: VideoSearch): List<VideoEntity>? {
        if (StringUtils.hasText(videoSearch.name)
            && StringUtils.hasText(videoSearch.description)) {
            return repository
                .findByNameContainsOrDescriptionContainsAllIgnoreCase(
                    videoSearch.name, videoSearch.description);
        }

        if (StringUtils.hasText(videoSearch.name)) {
            return repository.findByNameContainsIgnoreCase(videoSearch.name);
        }

        if (StringUtils.hasText(videoSearch.description)) {
            return repository.findByDescriptionContainsIgnoreCase(videoSearch.description);
        }

        return Collections.emptyList();
    }
}
