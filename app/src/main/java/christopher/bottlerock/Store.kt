package christopher.bottlerock


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StoreList(

    @SerializedName("stores")
    @Expose
    val stores: List<StoreX>
)


data class StoreX(

    @SerializedName("address") @Expose val address: String,
    @SerializedName("city") @Expose val city: String,
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("state") val  state: String,
    @SerializedName("storeID") val storeID: String,
    @SerializedName("storeLogoURL") val storeLogoURL: String,
    @SerializedName("zipcode") val zipcode: String
)