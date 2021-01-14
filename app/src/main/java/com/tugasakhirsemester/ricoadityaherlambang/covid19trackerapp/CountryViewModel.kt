package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel yang menggunakan data response API country.
 * Kelas yang berperan sebagai ViewModel dari CountryActivity.
 */
class CountryViewModel : ViewModel(){

    /**
     * Function untuk menjembatani antara View (yang ada di CountryActivity) agar dapat
     * berinteraksi dengan API country via repository untuk mendapatkan data country.
     * Function mem-pass data response dari API ke View menggunakan return.
     */
    fun getCountryDataFromApi(): MutableLiveData<Country> {
        return RemoteRepository().getCountryDataFromApi()
    }

}