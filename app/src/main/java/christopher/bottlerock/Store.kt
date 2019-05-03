package christopher.bottlerock

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/*
@Entity(tableName = "store_table")
data class Store(
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
)*/
@Entity(tableName = "store_table")
data class Store(
    @PrimaryKey(autoGenerate = true)
    //returns a list of store attributes from store X
    @SerializedName("stores")
    val stores: List<StoreX>
)

data class StoreX(
    //returns each individual attribute for each store
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("storeID")
    val storeID: String,
    @SerializedName("storeLogoURL")
    val storeLogoURL: String,
    @SerializedName("zipcode")
    val zipcode: String
)