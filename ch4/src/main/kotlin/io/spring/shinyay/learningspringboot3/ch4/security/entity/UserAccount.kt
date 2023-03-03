package io.spring.shinyay.learningspringboot3.ch4.security.entity

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
class UserAccount(
    val username: String?,
    val password: String?,
    @ElementCollection(fetch = FetchType.EAGER)
    val authorities: List<GrantedAuthority>?
) {
    constructor() : this("", "", null) {

    }

    @Id
    @GeneratedValue
    val id: Long? = null
}
