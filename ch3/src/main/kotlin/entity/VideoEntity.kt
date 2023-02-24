package entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


@Entity
internal class VideoEntity(var name: String?, var description: String?) {
    @Id
    @GeneratedValue
    var id: Long? = null

    protected constructor() : this(null, null)
}
