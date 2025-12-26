package entity.base

abstract class ListEntity<T : BaseEntity>(
    override val name: String,
    override val goBack: () -> Entity,
) : BaseEntity(name, goBack) {
    abstract val value: ArrayList<T>
    abstract val createCommandName: String

    override val contentView = ""
    override val menuView: String
        get() {
            var menu =
                value
                    .mapIndexed { i, element -> "${i + 1}: ${element.name}" }
                    .joinToString("\n")
            if (!menu.isEmpty()) {
                menu += "\n"
            }
            menu += "${value.size + 1}: $createCommandName"

            return menu
        }
    override val validator: (Int) -> Boolean = { it >= 0 && it <= value.size + 1 }

    override fun action(controller: Controller): Entity =
        when (val command = controller.getUserCommand(validator)) {
            value.size + 1 -> {
                val newElement = createElement(controller)
                value.add(newElement)
                this
            }

            0 -> {
                goBack()
            }

            else -> {
                value[command - 1]
            }
        }

    abstract fun createElement(controller: Controller): T
}
