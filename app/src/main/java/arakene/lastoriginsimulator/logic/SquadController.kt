package arakene.lastoriginsimulator.logic

import arakene.lastoriginsimulator.bioroid.Bioroid

class SquadController {

    private val map = HashMap<IntArray, Bioroid>()


    private var selectedPosition:IntArray? = null
    private var isSelected = false

    /**
     * 버튼을 누르면 해당 인덱스를 넘겨줄 거임
     */
    fun check(index : Int) {
        when (index) {
            1 -> control(0, 2)
            2 -> control(1, 2)
            3 -> control(2, 2)
            4 -> control(0, 1)
            5 -> control(1, 1)
            6 -> control(2, 1)
            7 -> control(0, 0)
            8 -> control(1, 0)
            9 -> control(2, 0)
        }
    }

    private fun control(x : Int, y : Int){
        if(map[intArrayOf(x, y)] == null){
            if (isSelected){ // 이미 바이오로이드가 선택되어 있고 빈칸은 누른 경우 -> 이동시킨다
                map[intArrayOf(x, y)] = map[selectedPosition]!!
                isSelected = false
            }
            else{ // 이미 선택된 바이오로이드가 없다 따라서 추가한다.
                //TODO Select Bioroid
            }
        }
        else{
            //TODO 바이오로이드 선택
            isSelected = true
        }
        selectedPosition = intArrayOf(x, y)



        var list = ArrayList<Bioroid>()

        map.values.map {
            list.add(it)
        }

        for (bioroid in map.values) {
            if (bioroid != null) {
                bioroid.applyPassive(list.toTypedArray())
            }
        }
    }

}