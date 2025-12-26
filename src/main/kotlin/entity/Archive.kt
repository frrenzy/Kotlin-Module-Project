package entity

import entity.base.ListEntity

class Archive(override val name: String, override val goBack: () -> Unit) :
    ListEntity<Note>(name, goBack) {

    override val value = arrayListOf<Note>()
    override val createCommandName = "Создать заметку"
    override val entityName = "Архив $name"

    override fun createElement(): Note {
        println("Введите название заметки:")
        val name = getUserText()
        println("Введите текст заметки:")
        val text = getUserText()
        return Note(name, text) { display() }
    }

}
