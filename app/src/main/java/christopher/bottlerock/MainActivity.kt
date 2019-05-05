package christopher.bottlerock


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list: List<StoreList> = Collections.emptyList()

        storeRecyclerView.layoutManager = LinearLayoutManager(this)
//        storeRecyclerView.adapter = StoreAdapter(list)

        val storeService = ServiceBuilder.buildService(StoreService::class.java)

        val requestCall = storeService.getStoreList()


        requestCall.enqueue(object : retrofit2.Callback<StoreList> {

            override fun onFailure(call: Call<StoreList>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                Log.e("Error",t.message)
            }

            override fun onResponse(call: Call<StoreList>, response: Response<StoreList>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT).show()
                        Log.i("Response", response.body().toString())
                        showData(response.body()!!)

                }
            }
        })

    }

    private fun showData(storeList: StoreList) {

        storeRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = StoreAdapter(storeList.stores, applicationContext) { store : StoreX -> onStoreClicked(store)}
        }

    }

    private fun onStoreClicked(store: StoreX){
        val storeActivity = Intent(this,StoreActivity::class.java)
            .apply {
                putExtra("address",store.address)
                putExtra("city",store.city)
                putExtra("latitude",store.latitude)
                putExtra("longitude",store.longitude)
                putExtra("name",store.name)
                putExtra("phone",store.phone)
                putExtra("state",store.state)
                putExtra("storeID",store.storeID)
                putExtra("storeLogoURL",store.storeLogoURL)
                putExtra("zipcode",store.zipcode)
            }
        startActivity(storeActivity)
    }

}

