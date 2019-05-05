package christopher.bottlerock


import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class StoreAdapter(private var storeList: List<StoreX>, private var context: Context, private var itemClickListener: (StoreX) -> Unit) : RecyclerView.Adapter<StoreAdapter.ViewHolder>(){

    override fun getItemCount(): Int = storeList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.bind(storeList[position],itemClickListener)

            val store : StoreX = storeList[position]

            holder.name.text = store.name
            holder.id.text = store.storeID

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(store:StoreX,clickListener: (StoreX) ->Unit){
            itemView.setOnClickListener {clickListener(store)}
        }

        val name: TextView = itemView.tvName
        val id: TextView = itemView.tvID


    }

}