package entity.base

abstract class ValueEntity<T>(
    override val name: String,
    val value: T,
    override val goBack: () -> Unit
) :
    BaseEntity(name, goBack) {

    override val validator: (Int) -> Boolean = { it == 0 }
    override fun action(command: Int) {
        goBack()
    }

    override fun showContent() {
        println(value)
    }

    override fun showMenu() = Unit
}
