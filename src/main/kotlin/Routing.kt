package com.lgw

import com.lgw.route.healthCheckRoutes
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import com.lgw.route.metricRoutes
import kotlinx.serialization.json.Json


fun Application.configureRouting() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        routing {
            // health check route
            healthCheckRoutes()
            // metrics route
            metricRoutes()

        }
    }.start(wait = true)
}
