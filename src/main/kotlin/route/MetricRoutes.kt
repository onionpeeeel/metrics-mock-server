package com.lgw.route

import com.lgw.model.Metric
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("MetricRoutes")
fun Route.metricRoutes() {
    route("/metrics") {
        post {
            val metric = call.receive<Metric>()
            logger.info("✅ Metrics Count Completed: $metric")
            call.respond(HttpStatusCode.OK, "Metric received")
        }
    }
}