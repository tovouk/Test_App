package christopher.bottlerock

import retrofit2.Call
import retrofit2.http.GET

interface StoreService {

    @GET("stores.json")
    fun getStoreList(): Call<StoreList>
}