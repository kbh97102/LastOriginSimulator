package arakene.lastoriginsimulator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import arakene.lastoriginsimulator.bioroid.Bioroid
import arakene.lastoriginsimulator.bioroid.BioroidStats
import arakene.lastoriginsimulator.bioroid.Skill
import arakene.lastoriginsimulator.logic.SquadController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val controller = SquadController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayOf(button1, button2, button3, button3, button4, button5, button6, button7, button8, button9).map {
            it.setOnClickListener {
                val button = it as Button
                controller.check(button.text.toString().toInt())
            }
        }
    }

}