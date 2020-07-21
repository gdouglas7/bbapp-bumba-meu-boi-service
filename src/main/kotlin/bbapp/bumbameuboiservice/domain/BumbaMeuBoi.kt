package bbapp.bumbameuboiservice.domain

import bbapp.bumbameuboiservice.application.model.Accent
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class BumbaMeuBoi(

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
        val id: String? = null,

        val name: String? = null,
        val city: String? = null,

        @CreationTimestamp
        @Column(updatable = false)
        val createdDate: OffsetDateTime? = OffsetDateTime.now(),

        @UpdateTimestamp
        val lastModifiedDate: OffsetDateTime? = OffsetDateTime.now(),

        val accent: Accent? = null,
        val pricePresentation: BigDecimal? = null
)