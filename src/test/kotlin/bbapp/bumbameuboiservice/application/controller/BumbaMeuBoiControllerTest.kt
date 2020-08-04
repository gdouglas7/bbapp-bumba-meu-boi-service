package bbapp.bumbameuboiservice.application.controller

import bbapp.bumbameuboiservice.application.model.BumbaMeuBoiDto
import bbapp.bumbameuboiservice.domain.service.BumbaMeuBoiService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
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

    @MockBean
    private lateinit var bumbaMeuBoiService: BumbaMeuBoiService

    private val baseUrl = "/api/v1/bumba-meu-boi/"

    @Test
    fun getBumbaMeuBoiById() {
        given(bumbaMeuBoiService.getById(anyString())).willReturn(BumbaMeuBoiDto())

        mockMvc.perform(get("$baseUrl${UUID.randomUUID()}").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
    }

    @Test
    fun saveNewBumbaMeuBoi() {

        given(bumbaMeuBoiService.saveNew(anyObject())).willReturn(BumbaMeuBoiDto())

        val bumbaMeuBoiJson = objectMapper.writeValueAsString(BumbaMeuBoiDto())
        mockMvc.perform(post(baseUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(bumbaMeuBoiJson))
                .andExpect(status().isCreated)
    }

    @Test
    fun updateBumbaMeuBoiById() {
        given(bumbaMeuBoiService.update(anyString(), anyObject())).willReturn(BumbaMeuBoiDto())

        val bumbaMeuBoiJson = objectMapper.writeValueAsString(BumbaMeuBoiDto())
        mockMvc.perform(put("$baseUrl${UUID.randomUUID()}")
                .contentType(MediaType.APPLICATION_JSON.toString())
                .content(bumbaMeuBoiJson))
                .andExpect(status().isNoContent)
    }

    private fun <T> anyObject(): T = Mockito.anyObject<T>()
}