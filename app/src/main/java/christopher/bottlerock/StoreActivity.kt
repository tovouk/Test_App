package christopher.bottlerock


import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        //TODO make getting store info easier, possibly making StoreX class into a parcelable
        //TODO reduce code repetition
        if (savedInstanceState != null) {
            Glide.with(this).load(savedInstanceState.getString("storeLogoURL")).into(storelogo)
            storeName.text = savedInstanceState.getString("name")
        }else{
            Glide.with(this).load(intent.getStringExtra("storeLogoURL")).into(storelogo)
            storeName.text = intent.getStringExtra("name")
        }


    }

    //TODO persist state
    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }

}
