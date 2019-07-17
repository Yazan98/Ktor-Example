package server

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.ws
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.readText
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.filterNotNull
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.runBlocking
import org.slf4j.event.Level
import utils.ReflexConsts
import view.DemoView

/**
 * Copyright 2019 Yazan Yarifi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * Created By : Yazan Tarifi
 * Date : 7/17/2019
 * Time : 2:37 PM
 */

@KtorExperimentalAPI
fun startServer() = embeddedServer(
    Netty,
    port = ReflexConsts.port,
    host = ReflexConsts.host
) {
//    startWebSocketConfiguration()
    addDefaultApplicationHeaders()
    DemoView()
}.start(wait = true)

@ObsoleteCoroutinesApi
@KtorExperimentalAPI
fun startWebSocketConfiguration() {
    runBlocking {
        val client = HttpClient(CIO).config { install(WebSockets) }
        client.ws(method = HttpMethod.Get, host = "192.168.1.9", port = 8080, path = "/myws/echo") {
            send(Frame.Text("Hello World"))
            for (message in incoming.map { it as? Frame.Text }.filterNotNull()) {
                println("Server said: " + message.readText())
            }
        }
    }
}

fun Application.addDefaultApplicationHeaders() {
    install(DefaultHeaders) {
        header("X-Developer", ReflexConsts.DeveloperName)
        header("X-Server", ReflexConsts.ServerName)
    }

    install(CallLogging) {
        level = Level.INFO
    }
}

