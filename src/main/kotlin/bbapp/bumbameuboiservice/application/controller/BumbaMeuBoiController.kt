package bbapp.bumbameuboiservice.application.controller

import bbapp.bumbameuboiservice.application.model.BumbaMeuBoiDto
import bbapp.bumbameuboiservice.domain.service.BumbaMeuBoiService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/bumba-meu-boi")
@RestController
class BumbaMeuBoiController(
        private val bumbaMeuBoiService: BumbaMeuBoiService
) {

    @GetMapping("/{bumbaMeuBoiId}")
    fun getBumbaMeuBoiById(@PathVariable("bumbaMeuBoiId") bumbaMeuBoiId: String): BumbaMeuBoiDto {
        return bumbaMeuBoiService.getById(bumbaMeuBoiId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewBumbaMeuBoi(@RequestBody bumbaMeuBoiDto: BumbaMeuBoiDto): BumbaMeuBoiDto{
        return bumbaMeuBoiService.saveNew(bumbaMeuBoiDto)
    }

    @PutMapping("/{bumbaMeuBoiId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBumbaMeuBoiById(
            @PathVariable("bumbaMeuBoiId") bumbaMeuBoiId: String,
            @RequestBody bumbaMeuBoiDto: BumbaMeuBoiDto
    ): BumbaMeuBoiDto {
        return bumbaMeuBoiService.update(bumbaMeuBoiId, bumbaMeuBoiDto)
    }

}