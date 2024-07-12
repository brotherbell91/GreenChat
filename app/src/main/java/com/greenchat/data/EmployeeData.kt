package com.greenchat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeData(
    var id: String = "",
    var name: String = "",
    var position: String = "",
) : Parcelable