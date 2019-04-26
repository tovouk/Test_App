package christopher.bottlerock

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item.view.*

class StoreAdapter(private val storeList: List<StoreX>) : RecyclerView.Adapter<StoreAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = storeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val store = storeList[position]
        holder.name.text = store.name
        holder.address.text = store.address
        holder.city.text = store.city
        holder.latitude.text = store.latitude
        holder.zip.text = store.zipcode
        holder.logo.text = store.storeLogoURL
        holder.phone.text = store.phone
        holder.longitude.text = store.longitude
        holder.id.text = store.storeID
        holder.state.text = store.state


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.tvName
        val address: TextView = itemView.tvAddress
        val city: TextView = itemView.tvCity
        val latitude: TextView = itemView.tvLat
        val zip: TextView = itemView.tvZip
        val logo: TextView = itemView.tvLogo
        val phone: TextView = itemView.tvPhone
        val longitude: TextView = itemView.tvLong
        val id: TextView = itemView.tvID
        val state: TextView = itemView.tvState
    }

}