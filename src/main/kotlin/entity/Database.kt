package entity

import entity.base.ListEntity

class Database(override val name: String, override val goBack: () -> Unit) :
    ListEntity<Archive>(name, goBack) {

    override val value = arrayListOf<Archive>()
    override val createCommandName = "Создать архив"
    override val entityName = "Список архивов"

    override fun createElement(): Archive {
        println("Введите название архива:")
        val name = getUserText()
        return Archive(name) { display() }
    }
}
