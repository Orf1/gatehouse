package orf1.dev.plugins

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureSecurity() {

    authentication {
        basic("auth") {
            realm = "Access to /"
            validate { credentials ->
                if (credentials.name == "Orf1" || credentials.password == "Space126") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }


    routing {
        authenticate("auth") {
            get("/") {
                call.respondText("Access Granted!")
            }
        }
    }
}
