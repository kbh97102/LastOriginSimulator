package arakene.lastoriginsimulator.bioroid

import arakene.lastoriginsimulator.R

/**
 * position 0 = x, 1 = y
 */

class Bioroid(
    private val _name: String,
    private val _level: Int,
    private var _activeSkills: Array<Skill>? = null,
    private var _passiveSkills: Array<Skill>,
    private var _image: Int? = null,
    var _currentPosition: IntArray = IntArray(2),
    private var _stats: HashMap<String, Double>,

) {
    val afterStats: HashMap<String, Double> = HashMap()
    val level get() = _level
    val activeSkill get() = _activeSkills
    val passiveSkills get() = _passiveSkills
    val name get() = _name
    val stats get() = _stats
    val image: () -> Int?
        get() = {
            if (_image == null) {
                R.drawable.ic_launcher_foreground
            } else {
                _image!!
            }
        }

    fun applyPassive(targets: Array<Bioroid>) {
        for (passive in passiveSkills) {
            passive.applyPassive(targets)
        }
    }

    fun initStat() {
        for (key in _stats.keys) {
            afterStats[key] = _stats[key]!!
        }
    }

    override fun toString(): String {
        return "Bioroid Information\n" +
                "name $_name\n" +
                "level $_level\n" +
                "passive ${_passiveSkills.contentDeepToString()}\n" +
                "currentPosition ${_currentPosition.contentToString()}\n" +
                "stat $_stats\n" +
                "After stat ${afterStats.toString()}"
    }

}