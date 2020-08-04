package bbapp.bumbameuboiservice.domain.service

import bbapp.bumbameuboiservice.application.model.BumbaMeuBoiDto

interface BumbaMeuBoiService {
    fun getById(bumbaMeuBoiId: String): BumbaMeuBoiDto
    fun saveNew(bumbaMeuBoiDto: BumbaMeuBoiDto): BumbaMeuBoiDto
    fun update(bumbaMeuBoiId: String, bumbaMeuBoiDto: BumbaMeuBoiDto) : BumbaMeuBoiDto
}