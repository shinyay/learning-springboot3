package io.spring.shinyay.learningspringboot3.ch4.security.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class UserAccount {
    @Id
    @GeneratedValue
    val id: Long? = null
}
