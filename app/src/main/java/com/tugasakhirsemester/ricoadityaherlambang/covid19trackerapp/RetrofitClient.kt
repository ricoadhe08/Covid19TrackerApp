package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Objek dari Retrofit client.
 * Objek dibuild dengan Retrofit Builder untuk nanti dapat digunakan untuk melakukan request HTTP ke API.
 * Hasil Builder ini ialah object retrofitCountryInstance & retrofitGlobalInstance.
 * Tiap instance menggunakan API (BASE_URL_) yang berbeda.
 **/
object RetrofitClient {

    /**
     * API untuk data tiap country ada di BASE_URL_COUNTRY
     * API untuk data global ada di BASE_URL_GLOBAL
     */
    private const val BASE_URL_COUNTRY = "https://api.covid19api.com/"
    private const val BASE_URL_GLOBAL = "https://disease.sh/"

    val retrofitCountryInstance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_COUNTRY)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

    val retrofitGlobalInstance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_GLOBAL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}