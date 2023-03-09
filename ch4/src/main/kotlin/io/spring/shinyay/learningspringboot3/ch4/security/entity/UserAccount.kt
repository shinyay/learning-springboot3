package io.spring.shinyay.learningspringboot3.ch4.security.entity

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*


@Entity
class UserAccount {
    @Id
    @GeneratedValue
    val id: Long? = null
    val username: String? = null
    val password: String? = null

    @ElementCollection(fetch = FetchType.EAGER)
    val authorities: MutableList<GrantedAuthority> = mutableListOf()
}
