package entity.base

interface Entity {
    fun action(controller: Controller): Entity

    val entityName: String
    val contentView: String
    val menuView: String
    val validator: (Int) -> Boolean

    val view: String
}

