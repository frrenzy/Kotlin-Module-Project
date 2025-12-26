package entity

import entity.base.Controller
import entity.base.ListEntity

class Database(
    override val name: String,
    override val goBack: () -> Archive,
) : ListEntity<Archive>(name, goBack) {
    override val value = arrayListOf<Archive>()
    override val createCommandName = "Создать архив"

    override val entityName = "Список архивов"

    override fun createElement(controller: Controller): Archive {
        val name = controller.getUserText("Введите название архива:")
        return Archive(name) { this }
    }
}
