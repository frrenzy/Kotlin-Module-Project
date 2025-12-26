package entity.base

interface Controller {
    fun getUserCommand(validator: (Int) -> Boolean): Int

    fun getUserText(question: String): String

    fun show(entity: Entity)
}

