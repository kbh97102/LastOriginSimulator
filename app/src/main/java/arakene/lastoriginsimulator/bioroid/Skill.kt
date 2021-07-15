package arakene.lastoriginsimulator.bioroid

open class Skill {

    companion object {
        const val APPLY = 1
        const val NONE = 0
    }

    var skillRange = arrayOf(
        IntArray(3),
        IntArray(3),
        IntArray(3)
    )

    var skillEffect = HashMap<String, Double>()

    fun applyPassive(targets: Array<Bioroid>) {
        for (target in targets) {
            if (isPosition(target, skillRange)) {
                for (stat in skillEffect.keys) {
                    target.stats[stat] = target.stats[stat]!! * skillEffect[stat]!!
                }
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