package arakene.lastoriginsimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arakene.lastoriginsimulator.bioroid.Bioroid
import arakene.lastoriginsimulator.bioroid.Skill

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superDragon = Bioroid(_name = "Dragon", level = 1, null, passiveSkills = arrayOf(Skill()), null, intArrayOf(0,0), HashMap())


    }
}