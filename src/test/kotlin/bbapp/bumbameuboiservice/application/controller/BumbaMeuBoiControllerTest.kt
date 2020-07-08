package bbapp.bumbameuboiservice.application.controller

import bbapp.bumbameuboiservice.application.model.BumbaMeuBoiDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.UUID

@WebMvcTest(BumbaMeuBoiController::class)
internal class BumbaMeuBoiControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private val baseUrl = "/api/v1/bumba-meu-boi/"

    @Test
    fun getBumbaMeuBoiById() {
        mockMvc.perform(get("$baseUrl${UUID.randomUUID()}").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
    }

    @Test
    fun saveNewBumbaMeuBoi() {

        val bumbaMeuBoiJson = objectMapper.writeValueAsString(BumbaMeuBoiDto())
        mockMvc.perform(post(baseUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(bumbaMeuBoiJson))
                .andExpect(status().isCreated)
    }

    @Test
    fun updateBumbaMeuBoiById() {
        val bumbaMeuBoiJson = objectMapper.writeValueAsString(BumbaMeuBoiDto())
        mockMvc.perform(put("$baseUrl${UUID.randomUUID()}")
                .contentType(MediaType.APPLICATION_JSON.toString())
                .content(bumbaMeuBoiJson))
                .andExpect(status().isNoContent)
    }
}