package com.greenchat.data

import android.os.Parcelable
import com.greenchat.R
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

@Parcelize
data class EmployeeData(
    var id: String = "",
    var name: String = "",
    var phone: String = "",
    var department: String = "",
    var position: String = "",
    var imageRes: Int = -1,
) : Parcelable {
    companion object {
        val myData = EmployeeData(id = "lhj", name = "이형종", phone = "010-0000-0000", department = "Develop1", position = "사원", imageRes = R.drawable.profile)
        val emptyData = EmployeeData(id = "", name = "", phone = "", department = "", position = "", imageRes = 1)
        val employeeData = EmployeeData(id = "hgd", name = "홍길동", phone = "010-0000-0000", department = "Develop2", position = "사원", imageRes = R.drawable.profile)

        val employeeDataList = arrayListOf(employeeData)
    }
}