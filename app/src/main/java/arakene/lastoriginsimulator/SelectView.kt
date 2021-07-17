package arakene.lastoriginsimulator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import arakene.lastoriginsimulator.bioroid.Bioroid
import arakene.lastoriginsimulator.bioroid.BioroidStats
import arakene.lastoriginsimulator.bioroid.Skill
import arakene.lastoriginsimulator.selector.SelectorAdapter
import kotlinx.android.synthetic.main.bioroid_select_layout.*

class SelectView : AppCompatActivity() {

    private lateinit var selectorAdapter: SelectorAdapter

    private val datas = ArrayList<Bioroid>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bioroid_select_layout)

        selectorAdapter = SelectorAdapter(this)
        selectorAdapter.datas = datas

        setDataList()

        recyclerView.apply {
            adapter = selectorAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SelectView)
        }

        Log.e("Data size", selectorAdapter.itemCount.toString())
    }

    private fun setDataList(){
        val skill = Skill()
        skill.apply {
            skillEffect[BioroidStats.ATTACK] = 1.3
            skillRange = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        }
        val superDragon = Bioroid(
            _name = "Dragon",
            _level = 1,
            null,
            _passiveSkills = arrayOf(skill),
            null,
            intArrayOf(0, 0),
            HashMap(),
            this.resources
        )

        datas.add(superDragon)
        selectorAdapter.notifyDataSetChanged()
    }

}