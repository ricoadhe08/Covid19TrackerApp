package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_country.*

/** Activity yang akan menampilkan list data covid-19 tiap negara berdasarkan API country. */
class CountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        /** Mengganti title dari AppBar ketika Activity ini dibuat. **/
        supportActionBar?.setTitle("Cases by Country")

        /** Mencari RecyclerView yang ada di layout. **/
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCountry)

        /** Digunakan untuk memberitahu RecyclerView untuk tetap menjaga size viewnya. **/
        recyclerView.setHasFixedSize(true)

        /**
         * Meng-assign recyclerview dengan LinearLayoutManager dari context/activity sekarang,
         * yang mana akan menampilkan list item RecyclerView secara vertikal atau horizontal.
         **/
        recyclerView.layoutManager = LinearLayoutManager(this)

        /** Membuat object ViewModelProvider dari CountryActivity dengan ViewModelnya adalah CountryViewModel.*/
        val countryViewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)

        /** Mencari dan men-set visibility ProgressBar di activity_country agar terlihat.*/
        val countryProgressBar = countryProgressBar
        countryProgressBar.visibility= View.VISIBLE

        /**
         * Membuat objek dari Anonymous Class Observer.
         * Di dalamnya ada setting adapter RecyclerView untuk menampilkan list dari item RecyclerView terlebih dahulu.
         * Diikuti men-set visibility ProgressBar menjadi tidak terlihat.
         * */
        val countryDataList = Observer<Country> {
            recyclerView.adapter = CountryAdapter(it.Countries)
            countryProgressBar.visibility = View.GONE
        }

        /**
         * Setelah objek dari kelas ViewModel telah dibuat, maka proses observing data dapat dilakukan.
         * Observing data dilakukan dengan method observe(). Method observe() membutuhkan 2 parameter,
         * pertama adalah context dari activity sekarang (digunakanlah this),
         * kedua adalah Anonymous Class Observer yang sudah dibuat di atas (objek countryDataList).
         * Data yang di-observe didapat melalui pemanggilan method getCountryDataFromApi() oleh objek
         * dari kelas ViewModel yang telah dibuat di atas (CountryViewModel)
         */
        countryViewModel.getCountryDataFromApi().observe(this, countryDataList)
    }
}