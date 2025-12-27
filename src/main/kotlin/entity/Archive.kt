package entity

import entity.base.Controller
import entity.base.ListEntity

class Archive(
    override val name: String,
    override val goBack: () -> Database,
) : ListEntity<Note>(name, goBack) {
    override val value = arrayListOf<Note>()
    override val createCommandName = "Создать заметку"

    override val entityName = "Архив $name"

    override fun createElement(controller: Controller): Note {
        val name = controller.getUserText("Введите название заметки:")
        val text = controller.getUserText("Введите текст заметки:")
        return Note(name, text) { this }
    }
}
