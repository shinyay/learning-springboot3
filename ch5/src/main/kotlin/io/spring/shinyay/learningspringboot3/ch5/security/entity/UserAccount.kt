package io.spring.shinyay.learningspringboot3.ch4.security.entity

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails


@Entity
class UserAccount() {

    @Id
    @GeneratedValue
    var id: Long? = null
    var username: String? = null
    var password: String? = null

    @ElementCollection(fetch = FetchType.EAGER)
    var authorities: MutableList<GrantedAuthority> = mutableListOf()

    constructor(username: String, password: String, vararg authorities: String)
            : this() {
        this.username = username
        this.password = password
        this.authorities = authorities
            .map(::SimpleGrantedAuthority)
            .map { it }
            .toMutableList()
    }

    fun asUser(): UserDetails {
        return User.withDefaultPasswordEncoder()
            .username(username)
            .password(password)
            .authorities(authorities)
            .build()
    }
}
