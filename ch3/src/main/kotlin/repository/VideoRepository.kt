package repository

import entity.VideoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VideoRepository : JpaRepository<VideoEntity?, Long?> {
    fun findByName(name: String): List<VideoEntity>

    fun findByNameContainsIgnoreCase(partialName: String)

    fun findByDescriptionContainsIgnoreCase(partialDescription:String)

    fun findByNameContainsOrDescriptionContainsAllIgnoreCase(partialName: String, partialDescription: String)
}
