package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/** Merupakan kelas yang berperan sebagai adapter untuk RecyclerView yang akan dipanggil di CountryActivity. */
class CountryAdapter (val countryDataList: List<CountryData>?) : RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    /**
     * Fun yang akan mengembalikan ViewHolder yang dibutuhkan oleh RecyclerView untuk menampilkan item.
     * ViewHoldernya disini adalah dari function CountryHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.country_list, parent, false)
        return CountryHolder(view)
    }

    /** Function untuk menghitung jumlah data yang diambil dari API country. */
    override fun getItemCount(): Int {
        return countryDataList!!.size
    }

    /**
     * Function yang akan mengupdate konten view holder dari RecyclerView yang mana akan mengupdate
     * TextView yang diambil oleh CountryHolder dengan mengganti value textnya dengan data
     * yang didapat dari API country.
     */
    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.countryNameTextView.text = countryDataList!!.get(position).Country
        holder.countryCasesTextView.text = countryDataList!!.get(position).TotalConfirmed.toString()
        holder.countryDeathsTextView.text = countryDataList!!.get(position).TotalDeaths.toString()
        holder.countryRecoveredTextView.text = countryDataList!!.get(position).TotalRecovered.toString()
    }

    /**
     * Mengambil TextView yang dipersiapkan layout country_list.xml agar nanti data dari API country
     * dapat ditempatkan pada TextView tersebut.
     */
    class CountryHolder(item: View) : RecyclerView.ViewHolder(item) {
        val countryNameTextView: TextView = item.findViewById(R.id.countryName)
        val countryCasesTextView: TextView = item.findViewById(R.id.countryTotalCases)
        val countryDeathsTextView: TextView = item.findViewById(R.id.countryTotalDeaths)
        val countryRecoveredTextView: TextView = item.findViewById(R.id.countryTotalRecovered)
    }

}