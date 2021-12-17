package orf1.dev

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import orf1.dev.plugins.configureSecurity

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureSecurity()
    }.start(true)
}
