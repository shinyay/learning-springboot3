package io.spring.shinyay.learningspringboot3.ch5.security.repository

import io.spring.shinyay.learningspringboot3.ch5.security.entity.UserAccount
import org.springframework.data.jpa.repository.JpaRepository

interface UserManagementRepository : JpaRepository<UserAccount, Long>
