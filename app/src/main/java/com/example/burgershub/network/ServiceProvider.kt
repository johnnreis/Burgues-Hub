package com.example.burgershub.network

import com.example.burgershub.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ServiceProvider {

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .addInterceptor(Interceptor { chain ->
            chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader(
                            name = "x-rapidapi-key",
                            value = BuildConfig.API_KEY
                        )
                        .build()
                )
            }
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun <API> createService(apiClass: Class<API>) : API = retrofit.create(apiClass)

}
