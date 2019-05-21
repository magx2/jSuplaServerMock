package pl.grzeslowski.jsuplaservermock

import io.swagger.model.ServerInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import pl.grzeslowski.jsuplaservermock.service.ServerService

@Service
class InMemoryDatabase(
        @Value("\${server.servlet.context-path}") val contextPath: String,
        @Value("\${server.port}") val port: String) : ServerService {
    override fun getServerInfo(): ServerInfo =
            ServerInfo()
                    .apiVersion("2.3.0")
                    .supportedApiVersions(listOf("2.3.0"))
                    .cloudVersion("2.3.0")
                    .address("http://localhost:$port$contextPath")
}