package arakene.lastoriginsimulator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import arakene.lastoriginsimulator.selector.SelectorAdapter
import kotlinx.android.synthetic.main.bioroid_select_layout.*

class SelectView : AppCompatActivity() {

    private lateinit var adapter: SelectorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bioroid_select_layout)

        adapter = SelectorAdapter()

        setDataList()

        recyclerView.apply {
            adapter = adapter
            setHasFixedSize(true)
        }
    }

    private fun setDataList(){

    }

}