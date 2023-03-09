package io.spring.shinyay.learningspringboot3.ch4.security.entity

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority


@Entity
class UserAccount() {

    @Id
    @GeneratedValue
    var id: Long? = null
    var username: String? = null
    var password: String? = null

    @ElementCollection(fetch = FetchType.EAGER)
    var authorities: List<GrantedAuthority> = mutableListOf()

    constructor(username: String, password: String, vararg authorities: String)
            : this() {
        this.username = username
        this.password = password
        this.authorities = authorities
            .map(::SimpleGrantedAuthority)
            .map { it as GrantedAuthority }
            .toList()
    }
}
