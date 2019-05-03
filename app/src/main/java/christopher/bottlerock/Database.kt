package christopher.bottlerock

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Store::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract val StoreDao: Database

    companion object {



        private var INSTANCE: Database? = null

        /*fun getInstance(context: Context):Database? {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        "store_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
            }
                return instance
        }
    }*/
}
}