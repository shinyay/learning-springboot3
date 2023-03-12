package io.spring.shinyay.learningspringboot3.ch4.video.repository

import io.spring.shinyay.learningspringboot3.ch4.video.entity.VideoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.access.prepost.PreAuthorize

interface VideoRepository : JpaRepository<VideoEntity?, Long?> {
    fun findByName(name: String): List<VideoEntity>

    fun findByNameContainsIgnoreCase(partialName: String): List<VideoEntity>

    fun findByDescriptionContainsIgnoreCase(partialDescription:String): List<VideoEntity>

    fun findByNameContainsOrDescriptionContainsAllIgnoreCase(
        partialName: String,
        partialDescription: String): List<VideoEntity>

    @PreAuthorize("#entity.username == authentication.name")
    override fun delete(entity: VideoEntity)
}
