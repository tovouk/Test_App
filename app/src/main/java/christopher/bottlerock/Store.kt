package christopher.bottlerock

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

data class Store(
    val stores: List<StoreX>
)

@Entity(tableName = "store_table")
data class StoreX(
    @PrimaryKey(autoGenerate = true)
    val address: String,
    val city: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val phone: String,
    val state: String,
    val storeID: String,
    val storeLogoURL: String,
    val zipcode: String
)