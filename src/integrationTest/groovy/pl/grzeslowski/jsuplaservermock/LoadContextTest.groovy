package pl.grzeslowski.jsuplaservermock

import io.swagger.Swagger2SpringBoot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest(classes = Swagger2SpringBoot.class)
class LoadContextTest extends Specification {

	@Autowired(required = false)
	ApplicationContext context

	def "should load application context"() {
		expect:
		context
	}
}
