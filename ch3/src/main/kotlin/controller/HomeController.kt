package controller

import dto.VideoSearch
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

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

    fun multiFieldSearch(@ModelAttribute search: VideoSearch, model: Model): String {

    }
}
