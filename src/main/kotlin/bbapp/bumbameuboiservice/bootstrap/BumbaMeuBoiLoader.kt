package bbapp.bumbameuboiservice.bootstrap

import bbapp.bumbameuboiservice.domain.BumbaMeuBoi
import bbapp.bumbameuboiservice.repositories.BumbaMeuBoiRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class BumbaMeuBoiLoader(
        private val bumbaMeuBoiRepository: BumbaMeuBoiRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {
        loadBumbaMeuBoiObjects()
    }

    private fun loadBumbaMeuBoiObjects() {
        if (bumbaMeuBoiRepository.count() == 0L){
            bumbaMeuBoiRepository.save(BumbaMeuBoi(
                name = "Boi da Maioba",
                city = "São Luis",
                pricePresentation = BigDecimal("5000.00")
            ))

            bumbaMeuBoiRepository.save(BumbaMeuBoi(
                    name = "Boi de Maracana",
                    city = "São Luis",
                    pricePresentation = BigDecimal("9000.00")
            ))
        }

        println("loaded Bumba Meu Boi: ${bumbaMeuBoiRepository.count()}")
    }
}