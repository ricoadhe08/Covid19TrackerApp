package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

/** Kelas ini merupakan model untuk menangani data response dari API country. */
data class CountryData (
    var Country: String,
    var TotalConfirmed: Int,
    var TotalDeaths: Int,
    var TotalRecovered: Int

)