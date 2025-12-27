package entity.base

abstract class BaseEntity(
    open val name: String,
    open val goBack: () -> Entity,
) : Entity {
    abstract override fun action(controller: Controller): Entity

    abstract override val entityName: String
    abstract override val contentView: String
    abstract override val menuView: String
    override val validator: (Int) -> Boolean = { it == 0 }

    override val view: String
        get() {
            var value = "$entityName:\n"
            if (!contentView.isEmpty()) {
                value += "$contentView\n"
            }
            value += "0: Выход"
            if (!menuView.isEmpty()) {
                value += "\n$menuView"
            }

            return value
        }
}
