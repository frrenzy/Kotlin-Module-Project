package entity.base

abstract class ValueEntity<T>(
    override val name: String,
    val value: T,
    override val goBack: () -> Entity,
) : BaseEntity(name, goBack) {
    override fun action(controller: Controller): Entity {
        controller.getUserCommand(validator)
        return goBack()
    }

    override val contentView = value.toString()
    override val menuView = ""
    override val validator: (Int) -> Boolean = { it == 0 }
}
