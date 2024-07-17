package com.greenchat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeData(
    var id: String = "",
    var name: String = "",
    var phone: String = "",
    var department: String = "",
    var position: String = "",
    var imageRes: Int = -1,
) : Parcelable