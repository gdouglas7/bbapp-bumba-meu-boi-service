package bbapp.bumbameuboiservice.application.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class BumbaMeuBoiPagedList(content: List<BumbaMeuBoiDto>) : PageImpl<BumbaMeuBoiDto>(content) {

    constructor(
            content: List<BumbaMeuBoiDto>,
            pageable: Pageable,
            total: Long
    ) : this(content)

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    constructor(
            @JsonProperty("content") content: List<BumbaMeuBoiDto>,
            @JsonProperty("number") number: Int,
            @JsonProperty("size") size: Int,
            @JsonProperty("totalElements") totalElements: Long,
            @JsonProperty("pageable") pageable: JsonNode,
            @JsonProperty("last") last: Boolean,
            @JsonProperty("totalPages") totalPages: Int,
            @JsonProperty("sort") sort: JsonNode,
            @JsonProperty("first") first: Boolean,
            @JsonProperty("numberOfElements") numberOfElements: Int
    ) : this(content)

}