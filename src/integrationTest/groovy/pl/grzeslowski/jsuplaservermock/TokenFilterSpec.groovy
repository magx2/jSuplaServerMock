package pl.grzeslowski.jsuplaservermock

import io.swagger.Swagger2SpringBoot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = Swagger2SpringBoot.class)
@AutoConfigureMockMvc
class TokenFilterSpec extends Specification {
	@Autowired
	MockMvc mvc

	@Value('${jsupla.token}')
	String token

	@Unroll
	def "should not add authorization on `#endpoint` endpoint"(String endpoint) {
		expect:
		mvc.perform(get(endpoint)).andExpect(status().isOk())

		where:
		endpoint << ['/api-docs', '/server-info']
	}

	def "should return 200 when authorization succeed"() {
		given:
		def request = get("/channels")
				.header("Authorization", "Bearer $token")

		expect:
		mvc.perform(request).andExpect(status().isOk())
	}

	def "should return 200 when authorization succeed (token with suffix)"() {
		given:
		def request = get("/channels")
				.header("Authorization", "Bearer ${token}.aHR0cDovL2xvY2FsaG9zdDo4MDgw")

		expect:
		mvc.perform(request).andExpect(status().isOk())
	}

	def "should return 403 when there is wrong authorization token"() {
		given:
		def request = get("/channels")
				.header("Authorization", "Bearer wrong")

		expect:
		mvc.perform(request).andExpect(status().isForbidden())
	}

	def "should return 401 when there is no authorization token"() {
		given:
		def request = get("/channels")

		expect:
		mvc.perform(request).andExpect(status().isUnauthorized())
	}
}
