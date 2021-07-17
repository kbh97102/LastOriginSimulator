package arakene.lastoriginsimulator.bioroid

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import arakene.lastoriginsimulator.R

/**
 * position 0 = x, 1 = y
 */

class Bioroid(
    private val _name: String,
    private val _level: Int,
    private var _activeSkills: ArrayList<Skill>? = null,
    private var _passiveSkills: Array<Skill>,
    private var _image:Bitmap? = null,
    private val _currentPosition:IntArray,
    private var _stats : HashMap<String, Double>,
    private val resource : Resources
) {

    val level get() = _level
    val activeSkill get() = _activeSkills
    val passiveSkills get() = _passiveSkills
    val name get() = _name
    val currentPosition get() = _currentPosition
    val stats get() = _stats
    val image: () -> Bitmap?
        get() = {
            if(_image == null){
                BitmapFactory.decodeResource(resource,R.drawable.test)
            }else{
                _image!!
            }
    }

    fun applyPassive(targets:Array<Bioroid>) {
        for (passive in passiveSkills) {
            passive.applyPassive(targets)
        }
    }


    override fun toString(): String {
        return "Bioroid Information\n" +
                "name $_name\n" +
                "level $_level\n" +
                "passive ${_passiveSkills}\n" +
                "currentPosition $_currentPosition\n" +
                "stat $_stats\n"
    }

}