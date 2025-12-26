import entity.Database
import kotlin.system.exitProcess

class App {
    fun start() {
        val database = Database("Список архивов") {
            exitProcess(0)
        }
        database.display()
    }
}
