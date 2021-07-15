package arakene.lastoriginsimulator.bioroid

import android.media.Image

open class Bioroid(
    private val _name: String,
    private val level: Int,
    private val activeSkills: ArrayList<Skill>,
    private val passiveSkills: ArrayList<Skill>,
    private val image:Image
) {

    val name get() = _name

}