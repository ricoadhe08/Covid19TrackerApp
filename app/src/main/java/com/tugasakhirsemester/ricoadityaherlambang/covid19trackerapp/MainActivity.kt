package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /** Membuat objek null dari TextView sebagai wadah dari TextView dari layout MainActivity. */
    private var globalConfirmed: TextView? = null
    private var globalDeaths: TextView? = null
    private var globalRecovered: TextView? = null
    /** Objek ProgressBar */
    private var globalProgressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Memanggil TextView dan ProgressBar yang ada di activity_main. */
        globalConfirmed = findViewById(R.id.globalConfirmed)
        globalDeaths = findViewById(R.id.globalDeaths)
        globalRecovered = findViewById(R.id.globalRecovered)
        globalProgressBar = findViewById(R.id.globalProgressBar)

        /* Set visibility dari ProgressBar menjadi terlihat. */
        globalProgressBar?.visibility = View.VISIBLE

        /** Memanggil function getGlobalData() untuk melakukan pengambilan dan penampilan data pada activity. */
        getGlobalData()

        /** Click button listener untuk memulai CountryActivity. */
        countriesButton.setOnClickListener{
            Intent(this@MainActivity, CountryActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    /** Function untuk mengambil data dari API global dan menampilkannya ke activity. */
    private fun getGlobalData(){

        /** Mengambil context dari activity sekarang (MainActivity). */
        val context = this@MainActivity

        /** Membuat object ViewModelProvider dari MainActivity dengan ViewModelnya adalah GlobalViewModel.*/
        val mainActivityViewModel = ViewModelProvider(this).get(GlobalViewModel::class.java)

        /**
         * Proses observing data dengan method observe().
         * Data diperoleh dari pemanggilan method getGlobalDataFromApi() oleh objek mainActivityViewModel dari kelas GlobalViewModel.
         * Method observe() membutuhka dua parameter, pertama context dari activity sekarang (digunakanlah this),
         * kedua adalah Anonymous Class Observer. Di dalam anonymous class tersebut terjadi proses penaruhan data
         * dari API global ke dalam objek TextView yang sudah dipersiapkan sebelumnya agar dapat ditampilkan di activity.
         */
        mainActivityViewModel.getGlobalDataFromApi()!!.observe(this, Observer { GlobalData ->
            globalConfirmed!!.text = GlobalData.cases.toString()
            globalDeaths!!.text =  GlobalData.deaths.toString()
            globalRecovered!!.text =  GlobalData.recovered.toString()
            globalProgressBar?.visibility = View.GONE
        })

    }


}