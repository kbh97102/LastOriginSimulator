package arakene.lastoriginsimulator.logic

import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import arakene.lastoriginsimulator.SelectView
import arakene.lastoriginsimulator.bioroid.Bioroid
import com.google.gson.Gson

class SquadController(private val activity: AppCompatActivity) {

    private val bioroidMap = HashMap<Int, Bioroid>()
    private var selectedPosition: Int? = null
    private var isSelected = false
    private val positionMap = HashMap<Int, IntArray>().apply {
        put(1, intArrayOf(0,2))
        put(2, intArrayOf(1,2))
        put(3, intArrayOf(2,2))
        put(4, intArrayOf(0,1))
        put(5, intArrayOf(1,1))
        put(6, intArrayOf(2,1))
        put(7, intArrayOf(0,0))
        put(8, intArrayOf(1,0))
        put(9, intArrayOf(2,0))
    }


    private val startActivity =
        activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                if (result.data != null) {
                    isSelected = false
                    val json = result.data!!.extras!!.get("data").toString()
                    val bioroid: Bioroid = Gson().fromJson(json, Bioroid::class.java)
                    bioroid._currentPosition = positionMap[selectedPosition!!]!!
                    bioroidMap[selectedPosition!!] = bioroid
                    selectedPosition = null
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

    private fun control(selected : Int) {
        if (bioroidMap[selected] == null) {
            if (isSelected) { // 이미 바이오로이드가 선택되어 있고 빈칸은 누른 경우 -> 이동시킨다
                bioroidMap[selected] = bioroidMap[selectedPosition]!!
                isSelected = false
            } else { // 이미 선택된 바이오로이드가 없다 따라서 추가한다.
                selectedPosition = selected
                val intent = Intent(activity, SelectView::class.java)
                startActivity.launch(intent)
            }
        } else {
            //TODO 바이오로이드 선택
            isSelected = true
        }
        selectedPosition = selected


//        var list = ArrayList<Bioroid>()
//
//        map.values.map {
//            list.add(it)
//        }
//
//        for (bioroid in map.values) {
//            if (bioroid != null) {
//                bioroid.applyPassive(list.toTypedArray())
//            }
//        }
    }

}