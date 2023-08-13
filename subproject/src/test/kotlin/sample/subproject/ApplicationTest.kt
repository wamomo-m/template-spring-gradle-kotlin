package sample.subproject

import io.kotest.core.spec.style.FreeSpec
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplicationTest : FreeSpec({
    "contextLoads" {
        println("Ok")
    }
})
