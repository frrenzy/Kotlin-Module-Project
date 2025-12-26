package entity.base

abstract class ListEntity<T : BaseEntity>(
    override val name: String,
    override val goBack: () -> Unit
) :
    BaseEntity(name, goBack) {

    abstract val value: ArrayList<T>
    abstract val createCommandName: String
    abstract fun createElement(): T

    override val validator: (Int) -> Boolean = { it >= 0 && it <= value.size + 1 }

    override fun showContent() = Unit

    override fun showMenu() {
        value.forEachIndexed { i, element -> println("${i + 1}: $element") }

        println("${value.size + 1}: $createCommandName")
    }

    override fun action(command: Int) {
        when (command) {
            value.size + 1 -> {
                val newElement = createElement()
                value.add(newElement)
                display()
            }

            0 -> goBack()
            else -> value[command - 1].display()
        }
    }
}
