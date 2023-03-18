package io.spring.shinyay.learningspringboot3.ch4.security.repository

import io.spring.shinyay.learningspringboot3.ch4.security.entity.UserAccount
import org.springframework.data.jpa.repository.JpaRepository

interface UserManagementRepository : JpaRepository<UserAccount, Long>
