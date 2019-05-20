package pl.grzeslowski.jsuplaservermock.controller

import io.swagger.api.ServerInfoApi
import io.swagger.api.ServerStatusApi
import io.swagger.model.ServerInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pl.grzeslowski.jsuplaservermock.Database

@RestController
class ServerController(val database: Database) : ServerInfoApi, ServerStatusApi {
    @GetMapping("/api/v2.3.0/server-info")
    override fun getServerInfo(): ResponseEntity<ServerInfo> = ResponseEntity.ok(database.serverInfo)

    @GetMapping("/api/v2.3.0/server-status")
    override fun getSuplaServerStatus(): ResponseEntity<Void> = ResponseEntity.ok().build()
}