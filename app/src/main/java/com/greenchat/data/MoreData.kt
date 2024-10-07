package com.greenchat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * type 1 = 기본
 * type 2 = 스위치
 * type 3 = 체크박스
 */

@Parcelize
data class MoreData(
    var id: Int = -1,
    var type: Int = -1,
    var name: String = "",
    var data: String = "",
) : Parcelable {
    companion object {
        val mores = listOf(
            MoreData(1, 1, "Basic"),
            MoreData(2, 2, "Switch", "true"),
            MoreData(3, 3, "CheckBox", "true"),
            MoreData(4, 1, "Example 1"),
            MoreData(5, 2, "Example 2", "true"),
            MoreData(6, 3, "Example 3", "false"),
            MoreData(7, 1, "Example 4", ),
            MoreData(8, 2, "Example 5", "false"),
            MoreData(9, 3, "Example 6", "true"),
            MoreData(10, 1, "Example 7", ),
            MoreData(11, 2, "Example 8", "false"),
            MoreData(12, 3, "Example 9", "false"),
        )
    }
}