package pl.grzeslowski.jsuplaservermock.controller

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
class ServerControllerSpec extends Specification {
	@Autowired
	MockMvc mvc

	def "should find server info"() {
		expect:
		mvc.perform(get("/api/v2.3.0/server-info")).andExpect(status().isOk())
	}

	def "should find server status"() {
		expect:
		mvc.perform(get("/api/v2.3.0/server-status")).andExpect(status().isOk())
	}
}
