package io.spring.shinyay.learningspringboot3.ch6.security.repository

import io.spring.shinyay.learningspringboot3.ch6.security.entity.UserAccount
import org.springframework.data.repository.Repository

interface UserRepository : Repository<UserAccount, Long> {

    fun findByUsername(username: String): UserAccount
}
