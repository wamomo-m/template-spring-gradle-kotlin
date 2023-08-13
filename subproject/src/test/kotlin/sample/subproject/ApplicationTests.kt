package sample.subproject

import io.kotest.core.spec.style.FreeSpec
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import sample.subproject.Application

@SpringBootTest
class ApplicationTests(
	dependencyInjectionWorks: Application
): FreeSpec ({
	"contextLoads" {
		println(dependencyInjectionWorks)
	}
})
