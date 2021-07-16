package arakene.lastoriginsimulator.selector

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arakene.lastoriginsimulator.bioroid.Bioroid

class SelectorAdapter : RecyclerView.Adapter<SelectorViewHolder>() {
    var datas = ArrayList<Bioroid>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = datas.size
}