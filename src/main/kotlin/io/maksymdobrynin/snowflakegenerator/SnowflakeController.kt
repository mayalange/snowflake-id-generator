package io.maksymdobrynin.snowflakegenerator

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/v1")
class SnowflakeController(private val generator: Generator) {
	private val logger = LoggerFactory.getLogger(SnowflakeController::class.java)

	@GetMapping("/next-id")
	suspend fun generate(): Long {
		val podName = System.getenv("HOSTNAME") ?: "unknown"
		val id = generator.nextId()

		logger.info("Pod '$podName' generated ID: $id")

		println("[$podName] $id")

		return id
	}
}
