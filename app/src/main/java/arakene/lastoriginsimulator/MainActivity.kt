package arakene.lastoriginsimulator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import arakene.lastoriginsimulator.bioroid.Bioroid
import arakene.lastoriginsimulator.bioroid.BioroidStats
import arakene.lastoriginsimulator.bioroid.Skill

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val skill = Skill()
        skill.apply {
            skillEffect[BioroidStats.ATTACK] = 1.3
            skillRange = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        }

        val superDragon = Bioroid(
            _name = "Dragon",
            level = 1,
            null,
            passiveSkills = arrayOf(skill),
            null,
            intArrayOf(0, 0),
            HashMap()
        )


    }
}