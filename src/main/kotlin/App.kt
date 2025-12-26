import entity.Database
import entity.base.Entity
import kotlin.system.exitProcess

class App {
    fun start() {
        val view = Console()

        var currentEntity: Entity =
            Database("Список архивов") {
                exitProcess(0)
            }

        while (true) {
            view.show(currentEntity)
            currentEntity = currentEntity.action(view)
        }
    }
}
