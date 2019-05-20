package pl.grzeslowski.jsuplaservermock

import io.swagger.Swagger2SpringBoot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = Swagger2SpringBoot.class)
@AutoConfigureMockMvc
class InitSpec extends Specification {
	@Autowired
	MockMvc mvc

	def "should get 200 on api docs endpoint"() {
		given:
		def request = get("/api-docs")

		expect:
		mvc.perform(request).andExpect(status().isOk())
	}
}
