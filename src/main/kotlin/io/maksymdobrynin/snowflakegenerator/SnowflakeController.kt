package io.maksymdobrynin.snowflakegenerator

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class SnowflakeController(private val generator: Generator) {
	@GetMapping("/next-id")
	suspend fun generate(): Long = generator.nextId()
}
