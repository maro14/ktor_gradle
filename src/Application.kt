package com.ktor_gradle

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val userData = "{\"users\" :[\"Eki\", \"Billy\", \"Tony\", \"Connor\"]}"

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("Hello world", ContentType.Text.Plain)
        }

        post("/") {
            val post = call.receive<String>()
            call.respondText("Received $post", ContentType.Text.Plain)
        }

        get("/users"){
            call.respondText(userData, ContentType.Text.Plain)
        }
 
    }

}

