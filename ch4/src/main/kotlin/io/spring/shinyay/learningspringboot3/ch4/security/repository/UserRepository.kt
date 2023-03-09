package io.spring.shinyay.learningspringboot3.ch4.security.repository

import io.spring.shinyay.learningspringboot3.ch4.security.entity.UserAccount
import org.springframework.data.repository.Repository

interface UserRepository : Repository<UserAccount, Long> {
    
}
