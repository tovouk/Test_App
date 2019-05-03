package christopher.bottlerock

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*


class StoreAdapter(private val storeList: List<StoreX>) : RecyclerView.Adapter<StoreAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = storeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val store = storeList[position]

        val context = holder.itemView.context

        holder.city.text = store.city
        holder.state.text = store.state

        Picasso.with(context)
            .load(store.storeLogoURL)
            .into(holder.name)

holder.parentLayout.setOnClickListener {
   // Toast.makeText(context, store.toString(), Toast.LENGTH_SHORT ).show()
    val intent = Intent(context, DetailActivity::class.java)
    intent.putExtra("name", store.name)
    intent.putExtra("address", store.address)
    intent.putExtra("city", store.city)
    intent.putExtra("long", store.longitude)
    intent.putExtra("lat", store.latitude)
    intent.putExtra("phone", store.phone)
    intent.putExtra("state", store.state)
    intent.putExtra("id", store.storeID)
    intent.putExtra("logo", store.storeLogoURL)
    intent.putExtra("zip", store.zipcode)
   startActivity(context, intent, null)

}
        // holder.address.text = store.address



    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: ImageView = itemView.tvName
        val city: TextView = itemView.tvMainCity
        val state: TextView = itemView.tvMainState

      val parentLayout : LinearLayout = itemView.linearLay

    }

    }

