package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    /**
     * @GET sebagai tanda untuk melakukan GET request (mendapatkan data) ke API dengan value adalah endpoint dari API yang digunakan.
     *
     * getCountryData(), function yang akan digunakan Retrofit untuk mengembalikan objek dari kelas Country,
     * dengan Call adalah bagian dari Retrofit yang akan membungkus objek hasil return kelas ini ketika mengirimkan response.
     *
     * getGlobalData(), sama seperti getCountryData() hanya saja dengan objek yang dikembalikan adalah dari kelas GlobalData.
    **/

    @GET("summary")
    //@GET("v3/covid-19/countries")
    fun getCountryData(): Call<Country>

    @GET("v3/covid-19/all")
    fun getGlobalData(): Call<GlobalData>

}