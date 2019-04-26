package christopher.bottlerock

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Store::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    companion object {

       // abstract val DatabaseDao: Database

        @Volatile
        private var INSTANCE: Database? = null

       /* fun getInstance(context: Context):Database {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
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