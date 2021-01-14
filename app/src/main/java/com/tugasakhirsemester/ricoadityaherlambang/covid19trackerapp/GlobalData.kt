package com.tugasakhirsemester.ricoadityaherlambang.covid19trackerapp

/** Kelas ini merupakan model untuk menangani data response dari API global. */
data class GlobalData (
    val cases: Int,
    val deaths: Int,
    val recovered: Int
)