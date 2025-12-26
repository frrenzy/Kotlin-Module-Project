package entity.base

import java.util.InputMismatchException
import java.util.Scanner

val scanner = Scanner(System.`in`)

abstract class BaseEntity(open val name: String, open val goBack: () -> Unit) {
    abstract fun action(command: Int)
    abstract fun showContent()
    abstract fun showMenu()
    open val validator: (Int) -> Boolean = { it == 0 }

    abstract val entityName: String

    fun getUserCommand(): Int {
        while (true) {
            val command: Int
            try {
                command = scanner.nextInt()
                if (!validator(command)) {
                    println("Введено неверное число")
                    continue
                }

                print("\u001b[H\u001b[2J")
                return command
            } catch (_: InputMismatchException) {
                println("Нужно ввести число")
                continue
            } finally {
                scanner.nextLine()
            }
        }
    }

    fun getUserText(): String {
        return scanner.nextLine()
    }

    fun display() {
        println("$entityName:")

        showContent()
        println("0: Выход")
        showMenu()

        action(getUserCommand())
    }

    override fun toString() = name
}
