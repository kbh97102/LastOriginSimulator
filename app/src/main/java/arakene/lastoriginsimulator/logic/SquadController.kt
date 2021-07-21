package arakene.lastoriginsimulator.logic

import android.content.Intent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import arakene.lastoriginsimulator.R
import arakene.lastoriginsimulator.SelectView
import arakene.lastoriginsimulator.bioroid.Bioroid
import com.google.gson.Gson
import kotlin.reflect.KFunction2

class SquadController(private val activity: AppCompatActivity) {

    private val bioroidMap = HashMap<Int, Bioroid?>()
    private var selectedPosition: Int = 0
    private var isSelected = false
    private val positionMap = HashMap<Int, IntArray>().apply {
        put(1, intArrayOf(0, 2))
        put(2, intArrayOf(1, 2))
        put(3, intArrayOf(2, 2))
        put(4, intArrayOf(0, 1))
        put(5, intArrayOf(1, 1))
        put(6, intArrayOf(2, 1))
        put(7, intArrayOf(0, 0))
        put(8, intArrayOf(1, 0))
        put(9, intArrayOf(2, 0))
    }
    var requestChangeButtonIcon: KFunction2<Int, Int, Unit>? = null

    private val startActivity =
        activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                if (result.data != null) {
                    val json = result.data!!.extras!!.get("data").toString()
                    val bioroid: Bioroid = Gson().fromJson(json, Bioroid::class.java)
                    bioroid._currentPosition = positionMap[selectedPosition]!!
                    bioroidMap[selectedPosition] = bioroid
                    if (requestChangeButtonIcon != null) {
                        requestChangeButtonIcon!!.invoke(bioroid.image.invoke()!!, selectedPosition)
                    }

                    isSelected = false
                    selectedPosition = 0
                }
            }
        }

    /**
     * 버튼을 누르면 해당 인덱스를 넘겨줄 거임
     */
    fun check(index: Int) {
        control(index)
//        when (index) {
//            1 -> control(0, 2)
//            2 -> control(1, 2)
//            3 -> control(2, 2)
//            4 -> control(0, 1)
//            5 -> control(1, 1)
//            6 -> control(2, 1)
//            7 -> control(0, 0)
//            8 -> control(1, 0)
//            9 -> control(2, 0)
//        }
    }

    private fun control(selected: Int) {
        if (isSelected && bioroidMap[selected] != null) { // 이미 바이오로이드가 선택되어 있고 다른 바이오로아드가 있어 교환
            toastMessage("Exchange ${bioroidMap[selectedPosition]!!.name} and ${bioroidMap[selected]!!.name}")
            bioroidMap[selectedPosition]!!._currentPosition = positionMap[selected]!!
            bioroidMap[selected]!!._currentPosition = positionMap[selectedPosition]!!
            val temp = bioroidMap[selectedPosition]
            bioroidMap[selectedPosition] = bioroidMap[selected]!!
            bioroidMap[selected] = temp!!
            requestChangeButtonIcon!!.invoke(
                bioroidMap[selectedPosition]!!.image.invoke()!!,
                selectedPosition
            )
            requestChangeButtonIcon!!.invoke(
                bioroidMap[selected]!!.image.invoke()!!,
                selected
            )
            isSelected = false
        }
        else if (isSelected && bioroidMap[selected] == null) { // 선택된 바이오 로이드가 있고 빈 공간으로 이동
            toastMessage("Move to Blank ${bioroidMap[selectedPosition]!!.name}")
            isSelected = false
            bioroidMap[selectedPosition]!!._currentPosition = positionMap[selected]!!
            bioroidMap[selected] = bioroidMap[selectedPosition]!!
            bioroidMap[selectedPosition] = null
            //TODO Blank Image Require
            requestChangeButtonIcon!!.apply {
                invoke(R.drawable.ic_launcher_foreground, selectedPosition)
                invoke(bioroidMap[selected]!!.image.invoke()!!, selected)
            }
        }
        else if (!isSelected && bioroidMap[selected] == null) {// 이미 선택된 바이오로이드가 없다 따라서 추가한다.
            toastMessage("Add Bioroid")
            selectedPosition = selected
            val intent = Intent(activity, SelectView::class.java)
            startActivity.launch(intent)
            isSelected = false
        } 
        else if(!isSelected && bioroidMap[selected] != null){// 선택한 적 없고 바이오 로이드 있는 칸을 선택
            toastMessage("Select Bioroid ${bioroidMap[selected]!!.name}")
            isSelected = true
        }
        selectedPosition = selected


        val list = ArrayList<Bioroid>()

        bioroidMap.values.map {
            if (it != null) {
                it.initStat()
                list.add(it)
            }
        }

        for (bioroid in list) {
            bioroid.applyPassive(list.toTypedArray())
        }
    }

    private fun toastMessage(msg: String) {
        Toast.makeText(activity.applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}