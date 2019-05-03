package christopher.bottlerock

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface StoreDao {

    @Query("SELECT * from store_table")
    fun getAllStores(): List<Store>


}