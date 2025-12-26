package entity

import entity.base.ValueEntity

class Note(override val name: String, text: String, override val goBack: () -> Unit) :
    ValueEntity<String>(name, text, goBack) {

    override val entityName = "Заметка $name"
}
