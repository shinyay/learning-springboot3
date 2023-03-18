package io.spring.shinyay.learningspringboot3.ch5.video.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


@Entity
class VideoEntity(var name: String?, var description: String?) {
    @Id
    @GeneratedValue
    var id: Long? = null

    constructor() : this(null, null)
}
