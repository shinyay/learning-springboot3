package repository

import entity.VideoEntity
import org.springframework.data.jpa.repository.JpaRepository

internal interface VideoRepository : JpaRepository<VideoEntity, Long> {
}
