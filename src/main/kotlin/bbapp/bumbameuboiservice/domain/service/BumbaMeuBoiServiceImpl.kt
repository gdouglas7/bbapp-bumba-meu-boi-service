package bbapp.bumbameuboiservice.domain.service

import bbapp.bumbameuboiservice.application.model.BumbaMeuBoiDto
import bbapp.bumbameuboiservice.repositories.BumbaMeuBoiRepository
import org.springframework.stereotype.Service

@Service
class BumbaMeuBoiServiceImpl(
        private val bumbaMeuBoiRepository: BumbaMeuBoiRepository
) : BumbaMeuBoiService {
    override fun getById(bumbaMeuBoiId: String): BumbaMeuBoiDto {

        return BumbaMeuBoiDto(bumbaMeuBoiRepository.findById(bumbaMeuBoiId).orElseThrow {NotFoundException()})
    }

    override fun saveNew(bumbaMeuBoiDto: BumbaMeuBoiDto): BumbaMeuBoiDto {
        return BumbaMeuBoiDto(bumbaMeuBoiRepository.save(bumbaMeuBoiDto.toBumbaMeuBoi()))
    }

    override fun update(bumbaMeuBoiId: String, bumbaMeuBoiDto: BumbaMeuBoiDto): BumbaMeuBoiDto {
        val bumbaMeuBoi = bumbaMeuBoiRepository.findById(bumbaMeuBoiId).orElseThrow {NotFoundException()}

        val newBumbaMeuBoi = bumbaMeuBoi.copy(
            name = bumbaMeuBoiDto.name,
            city = bumbaMeuBoiDto.city,
            createdDate = bumbaMeuBoiDto.createdDate,
            lastModifiedDate = bumbaMeuBoiDto.lastModifiedDate,
            accent = bumbaMeuBoiDto.accent
        )

        return BumbaMeuBoiDto(bumbaMeuBoiRepository.save(newBumbaMeuBoi))
    }
}