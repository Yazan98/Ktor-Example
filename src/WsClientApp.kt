import io.ktor.util.KtorExperimentalAPI
import server.startServer

object WsClientApp {

    @KtorExperimentalAPI
    @JvmStatic
    fun main(args: Array<String>) {
        startServer()
    }

}
