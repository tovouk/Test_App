package christopher.bottlerock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout.VERTICAL
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

        var storeList: List<StoreX>

        //var layoutManager: RecyclerView.LayoutManager
        lateinit var linearLayoutManager: LinearLayoutManager
        //var adapter: StoreAdapter
        lateinit var adapter: StoreAdapter

        requestCall.enqueue(object : retrofit2.Callback<Store> {
            override fun onFailure(call: Call<Store>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@MainActivity, "No data to display", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Store>, response: Response<Store>) {
                if (response.isSuccessful) {
                    Log.e("TAG", "response 33: " + response.body().toString())

                 storeList = response.body()!!.stores
                    //Toast.makeText(this@MainActivity, "adfads)" + storeList, Toast.LENGTH_LONG).show()
                    linearLayoutManager = LinearLayoutManager(this@MainActivity)
                    storeRecyclerView.layoutManager = linearLayoutManager
                    adapter = StoreAdapter(storeList)
                    storeRecyclerView.adapter = adapter
                   // val decoration = DividerItemDecoration(this@MainActivity, VERTICAL)
                    //storeRecyclerView.addItemDecoration(decoration)

                    val itemDecor = DividerItemDecoration(this@MainActivity, VERTICAL)
                    storeRecyclerView.addItemDecoration(itemDecor)



                }
            }
        })

        /*linearLayoutManager = LinearLayoutManager(this)
        storeRecyclerView.layoutManager = linearLayoutManager
        adapter = StoreAdapter(storeList)
        storeRecyclerView.adapter = adapter*/

    }



    /* private fun showData(storeList: Store?) {
 storeRecyclerView.apply {
     layoutManager = LinearLayoutManager(this@MainActivity)
     adapter=StoreAdapter(storeList)
 }
     }*/


}

