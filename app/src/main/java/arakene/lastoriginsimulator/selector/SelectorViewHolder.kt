package arakene.lastoriginsimulator.selector

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import arakene.lastoriginsimulator.bioroid.Bioroid
import arakene.lastoriginsimulator.databinding.ItemLayoutBinding
import kotlinx.android.synthetic.main.item_layout.view.*

class SelectorViewHolder(itemView: ItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {

    fun bind(bioroid: Bioroid){
        itemView.apply {
            bioroidName.text = bioroid.name
            if(bioroid.image != null){
                bioroidImage.setImageBitmap(bioroid.image.invoke())
            }
        }

    }


}