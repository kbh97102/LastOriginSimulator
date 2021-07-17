package arakene.lastoriginsimulator.selector

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import arakene.lastoriginsimulator.R
import arakene.lastoriginsimulator.bioroid.Bioroid
import arakene.lastoriginsimulator.databinding.ItemLayoutBinding

class SelectorAdapter : RecyclerView.Adapter<SelectorViewHolder>() {
    var datas = ArrayList<Bioroid>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {
        holder.itemView.setOnClickListener {


        }
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size
}