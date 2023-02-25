package controller

import dto.VideoSearch
import entity.Video
import entity.VideoEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import service.VideoService

@Controller
class HomeController(val videoService: VideoService) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("videos", videoService.getVideos())
        return "index"
    }

    @PostMapping("/new-video")
    fun newVideo(@ModelAttribute video: Video): String {
        videoService.create(video)
        return "redirect:/"
    }

    @PostMapping("/multi-field-search")
    fun multiFieldSearch(@ModelAttribute search: VideoSearch, model: Model): String {
        val searchResult: List<VideoEntity>? = videoService.search(search)
        model.addAttribute("videos", searchResult)
        return "index"
    }
}
