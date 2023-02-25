package service

import dto.VideoSearch
import entity.Video
import org.springframework.stereotype.Service

@Service
class VideoService {

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

    fun search(videoSearch: VideoSearch): List<VideoSearch>? {return null}
}
