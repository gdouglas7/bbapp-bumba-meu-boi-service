package bbapp.bumbameuboiservice.application.model

import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class BumbaMeuBoiPagedList(content: MutableList<BumbaMeuBoiDto>, pageable: Pageable, total: Long)
    : PageImpl<BumbaMeuBoiDto>(content, pageable, total) {
}