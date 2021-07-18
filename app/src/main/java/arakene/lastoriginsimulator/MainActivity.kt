package arakene.lastoriginsimulator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import arakene.lastoriginsimulator.logic.SquadController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val controller = SquadController(this)
    private val buttonList = ArrayList<ImageButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonList.apply {
            add(button1)
            add(button2)
            add(button3)
            add(button4)
            add(button5)
            add(button6)
            add(button7)
            add(button8)
            add(button9)
        }.map {
            it.setOnClickListener { it2 ->
                val buttonId = it.resources.getResourceName(it.id)
                controller.check(buttonId.split("_")[1].toInt())
            }
        }

        controller.requestChangeButtonIcon = this::changeButtonIcon


    }

    private fun changeButtonIcon(id: Int, position: Int) {
        runOnUiThread {
            Log.e("Request", "id $id, position $position")
            val positionString = position.toString()

            for(button in buttonList){
                val buttonId = resources.getResourceName(button.id)
                if (buttonId.split("_")[1] == positionString){
                    Log.e("Find button", "Find")
                    button.background = ContextCompat.getDrawable(this, id)
                    break
                }
            }

        }
    }


}