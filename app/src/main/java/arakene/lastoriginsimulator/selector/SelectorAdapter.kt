package arakene.lastoriginsimulator.selector

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import arakene.lastoriginsimulator.MainActivity
import arakene.lastoriginsimulator.bioroid.Bioroid
import arakene.lastoriginsimulator.databinding.ItemLayoutBinding
import com.google.gson.Gson

class SelectorAdapter(private val activity: AppCompatActivity) :
    RecyclerView.Adapter<SelectorViewHolder>() {
    var datas = ArrayList<Bioroid>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {
        holder.itemView.setOnClickListener { // TODO 선택된 바이오로이드 정보 json으로 넘김
            val data = Gson().toJson(datas[position])
            val intent = Intent(activity, MainActivity::class.java).apply {
                putExtra("data", data.toString())
            }
            activity.apply {
                setResult(RESULT_OK, intent)
                finish()
            }
        }
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size
}