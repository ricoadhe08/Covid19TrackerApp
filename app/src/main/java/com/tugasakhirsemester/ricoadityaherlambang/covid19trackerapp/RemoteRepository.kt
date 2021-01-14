package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * RemoteRepository berperan untuk berinteraksi dengan data remote (API) lewat Retrofit2,
 * melakukan request ke API dan menggunakan LiveData untuk mengobservasi data response dari API.
 */
class RemoteRepository {

    /**
     * getCountryDataFromApi()                        || getGlobalDataFromApi()
     * Fun yang menhandle data dari API data country || Fun yang menhandle data dari API data global.
     * Setiap fun terdapat Retrofit2 yang akan membuat sebuah client yang digunakan untuk berinteraksi
     * dengan API yang sudah didefinisikan pada kelas interface (ApiService).
     * Setiap data hasil response API disimpan pada objek LiveData (countryLiveData || globalLiveData),
     * untuk nanti dikembalikan nilai objeknya dengan return agar data APInya dapat di-pass ke ViewModel.
     */

    fun getCountryDataFromApi(): MutableLiveData<Country> {
        var countryLiveData= MutableLiveData<Country>()
        RetrofitClient.retrofitCountryInstance.getCountryData()
            .enqueue(object : Callback<Country> {
                override fun onFailure(call: Call<Country>, t: Throwable) {
                    Log.d("DEBUG", t.message.toString())
                }
                override fun onResponse(call: Call<Country>, response: Response<Country>) {
                    // masukkan body/isi dari response ke val countryLiveData
                    if (response.isSuccessful) {
                        Log.v("DEBUG : ", response.body().toString())
                        countryLiveData!!.postValue(response.body())
                    } else {
                        Log.d("Error", "Data tidak bisa didapatkan")
                    }
                }
            })
        return countryLiveData
    }

    fun getGlobalDataFromApi(): MutableLiveData<GlobalData> {
        var globalLiveData= MutableLiveData<GlobalData>()
        RetrofitClient.retrofitGlobalInstance.getGlobalData()
            .enqueue(object : Callback<GlobalData> {
                override fun onFailure(call: Call<GlobalData>, t: Throwable) {
                    Log.d("DEBUG", t.message.toString())
                }

                override fun onResponse(call: Call<GlobalData>, response: Response<GlobalData>) {
                    if (response.isSuccessful) {
                        Log.v("DEBUG : ", response.body().toString())
                        globalLiveData!!.postValue(response.body())
                    } else {
                        Log.d("Error", "Data tidak bisa didapatkan")
                    }
                }

            })
        return globalLiveData
    }

}