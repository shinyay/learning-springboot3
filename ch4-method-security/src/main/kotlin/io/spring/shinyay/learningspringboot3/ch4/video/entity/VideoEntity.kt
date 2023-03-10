package io.spring.shinyay.learningspringboot3.ch4.video.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


@Entity
internal class VideoEntity(var username: String?, var name: String?, var description: String?) {
    @Id
    @GeneratedValue
    var id: Long? = null

    constructor() : this(null, null, null)
}
