package arakene.lastoriginsimulator.item

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import arakene.lastoriginsimulator.bioroid.Item
import arakene.lastoriginsimulator.databinding.ItemLayoutBinding
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemViewHolder(itemView: ItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {

    fun bind(selectedItem : Item){
        itemView.bioroidName.text = selectedItem.name
    }

}