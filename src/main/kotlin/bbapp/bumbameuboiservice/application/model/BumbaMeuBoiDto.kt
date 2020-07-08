package bbapp.bumbameuboiservice.application.model

import java.time.OffsetDateTime

data class BumbaMeuBoiDto(
        val id: String? = null,
        val name: String? = null,
        val city: String? = null,
        val createdDate: OffsetDateTime? = OffsetDateTime.now(),
        val lastModifiedDate: OffsetDateTime? = OffsetDateTime.now(),
        val accent: Accent? = null
)

enum class Accent {
    ORQUESTRA, MATRACA, BAIXADA, COSTA_DE_MAO, ZABUMBA
}