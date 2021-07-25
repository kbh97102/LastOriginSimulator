package arakene.lastoriginsimulator.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arakene.lastoriginsimulator.bioroid.Item
import arakene.lastoriginsimulator.databinding.ItemLayoutBinding
import arakene.lastoriginsimulator.selector.SelectorViewHolder

class ItemAdapter(private var datas : Array<Item>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = datas.size

}