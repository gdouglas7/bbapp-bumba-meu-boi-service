package bbapp.bumbameuboiservice.application.model

import bbapp.bumbameuboiservice.domain.BumbaMeuBoi
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.OffsetDateTime

data class BumbaMeuBoiDto(
        val id: String? = null,
        val name: String? = null,
        val city: String? = null,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
        val createdDate: OffsetDateTime? = OffsetDateTime.now(),
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
        val lastModifiedDate: OffsetDateTime? = OffsetDateTime.now(),
        val accent: Accent? = null
){
    constructor(bumbaMeuBoi: BumbaMeuBoi) : this(
            id = bumbaMeuBoi.id,
            name = bumbaMeuBoi.name,
            city = bumbaMeuBoi.city,
            createdDate = bumbaMeuBoi.createdDate,
            lastModifiedDate = bumbaMeuBoi.lastModifiedDate,
            accent = bumbaMeuBoi.accent
    )

    fun toBumbaMeuBoi() = BumbaMeuBoi(
            name = this.name,
            city = this.city,
            createdDate = this.createdDate,
            lastModifiedDate = this.lastModifiedDate,
            accent = this.accent
    )
}

enum class Accent {
    ORQUESTRA, MATRACA, BAIXADA, COSTA_DE_MAO, ZABUMBA
}