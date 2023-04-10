package io.spring.shinyay.learningspringboot3.ch6.video.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


@Entity
class VideoEntity(var username: String?, var name: String?, var description: String?) {
    @Id
    @GeneratedValue
    var id: Long? = null

    constructor() : this(null, null, null)

    override fun toString(): String {
        return "VideoEntity{id=$id, username='$username', name='$name', description='$description'}"
    }
}
