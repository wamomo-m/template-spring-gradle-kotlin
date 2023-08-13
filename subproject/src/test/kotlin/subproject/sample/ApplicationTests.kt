package subproject.sample

import io.kotest.core.spec.style.FreeSpec
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import subproject.sample.Application

@SpringBootTest
class ApplicationTests(
	dependencyInjectionWorks: Application
): FreeSpec ({
	"contextLoads" {
		println(dependencyInjectionWorks)
	}
})
