package arakene.lastoriginsimulator.bioroid

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import arakene.lastoriginsimulator.R

/**
 * position 0 = x, 1 = y
 */

class Bioroid(
    private val _name: String,
    private val level: Int,
    private var activeSkills: ArrayList<Skill>? = null,
    private var passiveSkills: Array<Skill>,
    private var _image:Bitmap? = null,
    private val _currentPosition:IntArray,
    private var _stats : HashMap<String, Double>
) {

    val name get() = _name
    val currentPosition get() = _currentPosition
    val stats get() = _stats
    val image: () -> Bitmap?
        get() = {
            if(_image == null){
                BitmapFactory.decodeFile("")
            }else{
                _image!!
            }
    }

    fun applyPassive(targets:Array<Bioroid>) {
        for (passive in passiveSkills) {
            passive.applyPassive(targets)
        }
    }




}