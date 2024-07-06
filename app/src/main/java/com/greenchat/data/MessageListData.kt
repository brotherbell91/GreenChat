package com.greenchat.data

import android.os.Parcelable
import com.greenchat.R
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class MessageListData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var name: String = "",
    var receiverCount: Int = -1,
    var time: LocalDateTime = LocalDateTime.now(),
    var sender: String = "",
    var receiver: String = "",
    var unread: Int = -1,
) : Parcelable  {
    companion object{
        val receiveMessages = listOf(
            MessageListData(1, R.drawable.profile, "Receive Message 1", 3, LocalDateTime.now(), "홍길동", "이형종, 김동범, 오수빈", 1),
            MessageListData(2, R.drawable.profile, "Receive Message 2", 3, LocalDateTime.of(2022, 6,7, 8, 16,32 ), "박광현", "이형종, 이빛나, 이동혁", 1),
            MessageListData(3, R.drawable.profile, "Receive Message 3", 2, LocalDateTime.of(2022, 5,7, 6, 16,32 ), "김수빈", "이동혁, 이형종", 0),
            MessageListData(4, R.drawable.profile, "Receive Message 4", 2, LocalDateTime.of(2022, 4,9, 12, 18,32 ), "김종범", "이수빈, 이형종", 1),
            MessageListData(5, R.drawable.profile, "Receive Message 5", 3, LocalDateTime.of(2020, 6,9, 8, 16,32 ), "김다빈", "김동범, 이형종, 이수빈", 0),
            MessageListData(6, R.drawable.profile, "Receive Message 6", 3, LocalDateTime.of(2020, 6,7, 8, 15,55 ), "홍수빈", "이빛나, 이형종, 이종혁", 1),
            MessageListData(7, R.drawable.profile, "Receive Message 7", 4, LocalDateTime.of(2019, 6,7, 8, 16,32 ), "김다정", "이안나, 이형종, 박다정, 안지민", 1),
            MessageListData(8, R.drawable.profile, "Receive Message 8", 5, LocalDateTime.of(2018, 6,7, 8, 16,32 ), "이지현", "안지민, 이형종, 이수박, 박메론, 토마토", 1),
            MessageListData(9, R.drawable.profile, "Receive Message 9", 5, LocalDateTime.of(2017, 6,7, 8, 16,32 ), "박대현", "이형종, 바나나, 둘리, 코난, 포도", 0),
            MessageListData(10, R.drawable.profile, "Receive Message 10", 6, LocalDateTime.of(2016, 6,7, 8, 16,32 ), "박금빈", "수박, 포도, 사과, 바나나, 당근, 양배추", 1),
        )

        val sendMessages = listOf(
            MessageListData(1, R.drawable.profile, "Send Message 1", 3, LocalDateTime.now(), "이형종", "홍길동, 김동범, 오수빈", 0),
            MessageListData(2, R.drawable.profile, "Send Message 2", 3, LocalDateTime.of(2023, 6,7, 8, 16,32 ), "이형종", "박서현, 이빛나, 이동혁", 0),
            MessageListData(3, R.drawable.profile, "Send Message 3", 4, LocalDateTime.of(2022, 6,7, 8, 16,32 ), "이형종", "이안나, 김다정, 박다정, 안지민", 0),
            MessageListData(4, R.drawable.profile, "Send Message 4", 3, LocalDateTime.of(2021, 6,9, 8, 16,32 ), "이형종", "김동범, 김다빈, 이수빈", 0),
            MessageListData(5, R.drawable.profile, "Send Message 5", 3, LocalDateTime.of(2019, 6,7, 8, 15,55 ), "이형종", "이빛나, 홍수빈, 이종혁", 0),
            MessageListData(6, R.drawable.profile, "Send Message 6", 5, LocalDateTime.of(2018, 6,7, 8, 16,32 ), "이형종", "안지민, 이지현, 조수박, 박메론, 토마토", 0),
            MessageListData(7, R.drawable.profile, "Send Message 7", 5, LocalDateTime.of(2017, 6,7, 8, 16,32 ), "이형종", "박대현, 바나나, 둘리, 코난, 포도", 0),
        )
    }
}