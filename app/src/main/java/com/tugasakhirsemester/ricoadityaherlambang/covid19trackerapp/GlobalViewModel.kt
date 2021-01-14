package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel yang menggunakan data response API global.
 * Kelas yang berperan sebagai ViewModel dari MainActivity.
 */
class GlobalViewModel: ViewModel() {

    /**
     * Function untuk menjembatani antara View (yang ada di MainActivity) agar dapat
     * berinteraksi dengan API country via repository untuk mendapatkan data global.
     * Function mem-pass data response dari API ke View menggunakan return.
     */
    fun getGlobalDataFromApi(): MutableLiveData<GlobalData> {
        return RemoteRepository().getGlobalDataFromApi()
    }

}