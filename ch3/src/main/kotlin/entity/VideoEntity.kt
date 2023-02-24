package entity

import jakarta.persistence.Entity

@Entity
class VideoEntity(
    val id: Long,
    val name: String,
    val description: String) {
}
