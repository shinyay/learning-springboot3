package io.spring.shinyay.learningspringboot3.ch5.security.repository

import io.spring.shinyay.learningspringboot3.ch5.security.entity.UserAccount
import org.springframework.data.repository.Repository

interface UserRepository : Repository<UserAccount, Long> {

    fun findByUsername(username: String): UserAccount
}
