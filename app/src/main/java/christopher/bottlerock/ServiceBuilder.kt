package christopher.bottlerock

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {


    const val BASE_URL = "http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/"

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    private val okHttp = OkHttpClient.Builder().addInterceptor(logger)



    //Creates Retrofit builder
    private val builder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //Creates Retrofit Instance
    private val retrofit = builder.build()

    fun <T> buildService(serviceType:Class<T>) :T {
        return retrofit.create(serviceType)
    }


}