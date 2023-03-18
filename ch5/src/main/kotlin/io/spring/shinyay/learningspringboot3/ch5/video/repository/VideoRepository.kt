package io.spring.shinyay.learningspringboot3.ch4.video.repository

import io.spring.shinyay.learningspringboot3.ch4.video.entity.VideoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VideoRepository : JpaRepository<VideoEntity?, Long?> {
    fun findByName(name: String): List<VideoEntity>

    fun findByNameContainsIgnoreCase(partialName: String): List<VideoEntity>

    fun findByDescriptionContainsIgnoreCase(partialDescription:String): List<VideoEntity>

    fun findByNameContainsOrDescriptionContainsAllIgnoreCase(
        partialName: String,
        partialDescription: String): List<VideoEntity>
}
