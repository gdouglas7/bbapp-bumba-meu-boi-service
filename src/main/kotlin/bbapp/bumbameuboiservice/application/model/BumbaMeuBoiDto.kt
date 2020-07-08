package bbapp.bumbameuboiservice.application.model

import java.time.OffsetDateTime

data class BumbaMeuBoiDto(
        val id: String,
        val name: String,
        val city: String,
        val createdDate: OffsetDateTime,
        val lastModifiedDate: OffsetDateTime,
        val accent: Accent
)

enum class Accent {
    ORQUESTRA, MATRACA, BAIXADA, COSTA_DE_MAO, ZABUMBA
}