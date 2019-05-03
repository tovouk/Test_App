package christopher.bottlerock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailName: String = intent.getStringExtra("name")
        val detailLogo: String = intent.getStringExtra("logo")
        val detailAddress: String = intent.getStringExtra("address")
        val detailZip: String = intent.getStringExtra("zip")
        val detailState: String = intent.getStringExtra("state")
        val detailPhone: String = intent.getStringExtra("phone")
        val detailCity: String = intent.getStringExtra("city")
        val detailLong: String = intent.getStringExtra("long")
        val detailLat: String = intent.getStringExtra("lat")
        val detailId: String = intent.getStringExtra("id")


        val tvName=findViewById(R.id.textViewName) as TextView
        tvName.text = detailName

        val tvLogo=findViewById(R.id.imageViewLogo) as ImageView
        Picasso.with(this@DetailActivity)
            .load(detailLogo)
            .into(tvLogo)

        val tvAddress=findViewById(R.id.textViewAddress) as TextView
        tvAddress.text = detailAddress

        val tvZip=findViewById(R.id.textViewZip) as TextView
        tvZip.text = detailZip

        val tvState=findViewById(R.id.textViewState) as TextView
        tvState.text = detailState

        val tvCity=findViewById(R.id.tvDetailCity) as TextView
        tvCity.text = detailCity

        val tvPhone=findViewById(R.id.tvPhone) as TextView
        tvPhone.text = detailPhone

        val tvLong=findViewById(R.id.tvLong) as TextView
        tvLong.text = detailLong

        val tvLat=findViewById(R.id.tvLat) as TextView
        tvLat.text = detailLat

        val tvId=findViewById(R.id.tvStoreId) as TextView
        tvId.text = "Store # $detailId"


    }

}