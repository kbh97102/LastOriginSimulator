package arakene.lastoriginsimulator.bioroid

import android.media.Image

/**
 * position 0 = x, 1 = y
 */

class Bioroid(
    private val _name: String,
    private val level: Int,
    private var activeSkills: ArrayList<Skill>? = null,
    private var passiveSkills: Array<Skill>,
    private var image:Image? = null,
    private val _currentPosition:IntArray,
    private var _stats : HashMap<String, Double>
) {

    val name get() = _name
    val currentPosition get() = _currentPosition
    val stats get() = _stats


    fun applyPassive(targets:Array<Bioroid>) {
        for (passive in passiveSkills) {
            passive.applyPassive(targets)
        }
    }




}