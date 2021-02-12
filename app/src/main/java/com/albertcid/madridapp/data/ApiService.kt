package com.albertcid.madridapp.data


import com.albertcid.madridapp.BASE_URL
import com.albertcid.madridapp.ELDERY_CENTER_URL
import com.albertcid.madridapp.FAMILY_CENTER_URL
import com.albertcid.madridapp.data.model.NetworkDataWrapper
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET(ELDERY_CENTER_URL)
    fun getElderlyCenter(): Single<NetworkDataWrapper>

    @GET(FAMILY_CENTER_URL)
    fun getFamiliyCenter(): Single<NetworkDataWrapper>

    companion object {
        fun create(): ApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}