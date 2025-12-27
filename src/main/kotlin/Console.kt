import entity.base.Controller
import entity.base.Entity
import java.util.InputMismatchException
import java.util.Scanner

class Console : Controller {
    companion object {
        val scanner = Scanner(System.`in`)
    }

    override fun show(entity: Entity) = println(entity.view)

    override fun getUserCommand(validator: (Int) -> Boolean): Int {
        while (true) {
            val command: Int
            try {
                command = scanner.nextInt()
                if (!validator(command)) {
                    println("Введено неверное число")
                    continue
                }

                return command
            } catch (_: InputMismatchException) {
                println("Нужно ввести число")
                continue
            } finally {
                scanner.nextLine()
            }
        }
    }

    override fun getUserText(question: String): String {
        println(question)
        while (true) {
            var result = scanner.nextLine()

            if (result.isEmpty()) {
                println("Пустые значения запрещены")
                continue
            }

            return result
        }
    }
}

