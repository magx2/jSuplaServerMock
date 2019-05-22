package pl.grzeslowski.jsuplaservermock.controller

import io.swagger.api.ServerInfoApi
import io.swagger.api.ServerStatusApi
import io.swagger.model.ServerInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import pl.grzeslowski.jsuplaservermock.service.ServerService

@RestController
class ServerController(private val serverService: ServerService) : ServerInfoApi, ServerStatusApi {
    override fun getServerInfo(): ResponseEntity<ServerInfo> = ResponseEntity.ok(serverService.serverInfo)

    override fun getSuplaServerStatus(): ResponseEntity<Void> = ResponseEntity.ok().build()
}