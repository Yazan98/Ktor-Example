import io.ktor.util.KtorExperimentalAPI
import server.startServer


object ReflexApplication {

    @KtorExperimentalAPI
    @JvmStatic
    fun main(args: Array<String>) {
        startServer()
    }

}
