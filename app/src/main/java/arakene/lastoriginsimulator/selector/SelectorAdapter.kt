package arakene.lastoriginsimulator.selector

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arakene.lastoriginsimulator.R
import arakene.lastoriginsimulator.bioroid.Bioroid

class SelectorAdapter : RecyclerView.Adapter<SelectorViewHolder>() {
    var datas = ArrayList<Bioroid>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return SelectorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = datas.size
}