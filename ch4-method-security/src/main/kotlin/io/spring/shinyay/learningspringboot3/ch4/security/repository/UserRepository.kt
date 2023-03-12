package io.spring.shinyay.learningspringboot3.ch4.security.repository

import io.spring.shinyay.learningspringboot3.ch4.security.entity.UserAccount
import io.spring.shinyay.learningspringboot3.ch4.video.entity.VideoEntity
import org.springframework.data.repository.Repository
import org.springframework.security.access.prepost.PreAuthorize

interface UserRepository : Repository<UserAccount, Long> {

    fun findByUsername(username: String): UserAccount

    @PreAuthorize("#entity.username == authentication.name")
    fun delete(entity: VideoEntity)
}
