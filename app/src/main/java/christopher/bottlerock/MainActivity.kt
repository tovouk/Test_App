package christopher.bottlerock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val storeService = ServiceBuilder.buildService(StoreService::class.java)

        val requestCall = storeService.getStoreList()

        requestCall.enqueue(object : retrofit2.Callback<List<StoreX>> {
            override fun onFailure(call: Call<List<StoreX>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No data to display", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<StoreX>>, response: Response<List<StoreX>>) {
                if (response.isSuccessful) {
                    showData(response.body()!!)

                }
            }
        })

    }

    private fun showData(storeList: List<StoreX>) {
        storeRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = StoreAdapter(storeList)
        }

    }
}

