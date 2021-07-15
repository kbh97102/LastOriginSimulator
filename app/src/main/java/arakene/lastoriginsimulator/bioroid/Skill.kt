package arakene.lastoriginsimulator.bioroid

open class Skill {

    companion object {
        const val APPLY = 1
        const val NONE = 0
        const val PASSIVE1 = "passive1"
        const val PASSIVE2 = "passive2"
        const val PASSIVE3 = "passive3"
    }

    var passive1 = arrayOf(
        IntArray(3),
        IntArray(3),
        IntArray(3)
    )

    var passive2 = arrayOf(
        IntArray(3),
        IntArray(3),
        IntArray(3)
    )

    var passive3 = arrayOf(
        IntArray(3),
        IntArray(3),
        IntArray(3)
    )

    var passiveEffect = HashMap<String, HashMap<String, Double>>()

    fun applyPassive(targets: Array<Bioroid>) {
        for (target in targets) {
            if (isPosition(target, passive1)) {
                val effects = passiveEffect[PASSIVE1]!!
                for (key in effects.keys) {
                    val targetStat = target.stats[key]
                    target.stats[key] = targetStat!! * effects[key]!!
                }
            }
            if (isPosition(target, passive2)) {

            }
            if (isPosition(target, passive3)) {

            }
        }
    }

    private fun isPosition(target: Bioroid, passive: Array<IntArray>): Boolean {
        val x = target.currentPosition[0]
        val y = target.currentPosition[1]

        if (passive[y][x] == APPLY) {
            return true
        }
        return false
    }

}