package pl.grzeslowski.jsuplaservermock.service

import io.swagger.Swagger2SpringBoot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = Swagger2SpringBoot.class)
@AutoConfigureMockMvc
class EntityNotFoundExceptionSpec extends Specification {
	@Autowired
	MockMvc mvc

	@Value('${jsupla.token}')
	String token

	def "should return 404 if EntityNotFoundException was thrown"() {
		given:
		def request = get("/iodevices/1").header("Authorization", "Bearer $token")

		expect:
		mvc.perform(request).andExpect(status().is(404))
	}
}
