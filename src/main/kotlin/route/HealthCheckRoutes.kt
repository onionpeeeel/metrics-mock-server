package com.lgw.route

import com.lgw.model.Metric
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("HealthCheckRoutes")
fun Route.healthCheckRoutes() {
    route("/healthCheck") {
        post {
            val metric = call.receive<Metric>()
            logger.info("✅ healthCheck Completed: $metric")
            call.respond(HttpStatusCode.OK, "Metric received")
        }
    }
}