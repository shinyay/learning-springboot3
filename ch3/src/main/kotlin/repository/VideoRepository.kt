package repository

import entity.VideoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VideoRepository : JpaRepository<VideoEntity?, Long?> {
    fun findByName(name: String): List<VideoEntity>
}
