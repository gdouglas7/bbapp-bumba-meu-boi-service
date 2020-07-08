package bbapp.bumbameuboiservice.application.controller

import bbapp.bumbameuboiservice.application.model.BumbaMeuBoiDto
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
class BumbaMeuBoiController {

    @GetMapping("/{bumbaMeuBoiId}")
    fun getBumbaMeuBoiById(@PathVariable("bumbaMeuBoiId") bumbaMeuBoiId: String) {

    }

    @PostMapping
    fun saveNewBumbaMeuBoi(@RequestBody bumbaMeuBoiDto: BumbaMeuBoiDto){

    }

    @PutMapping("/{bumbaMeuBoiId}")
    fun updateBumbaMeuBoiById(
            @PathVariable("bumbaMeuBoiId") bumbaMeuBoiId: String,
            @RequestBody bumbaMeuBoiDto: BumbaMeuBoiDto
    ) {

    }

}