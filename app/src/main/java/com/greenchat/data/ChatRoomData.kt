package com.greenchat.data

import com.greenchat.R
import java.time.LocalDateTime

data class ChatRoomData(
    var id: Int = -1,
    var imageRes: Int = -1,
    var name: String = "",
    var participantsCount: Int = -1,
    var participants: List<EmployeeData> = emptyList(),
    var chats: List<ChatData> = emptyList(),
) {
    companion object{
        val chatRoom = listOf(
            ChatRoomData(
                id = 1,
                imageRes = R.drawable.profile,
                name = "Chat Room 1",
                participantsCount = 5,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 3, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 3, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 3, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 2, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 2,
                imageRes = R.drawable.profile,
                name = "Chat Room 2",
                participantsCount = 5,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박원빈", 3, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(2, imageRes = R.drawable.profile, "김수빈", 2, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "원빈", 2, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(4, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 3,
                imageRes = R.drawable.profile,
                name = "Chat Room 3",
                participantsCount = 8,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                    EmployeeData(id = "hgd",name = "홍길동", position = "사원"),
                    EmployeeData(id = "hsj",name = "홍수진", position = "사원"),
                    EmployeeData(id = "khw",name = "강형욱", position = "사원"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박원빈", 7, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(2, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "원빈", 3, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(4, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 4,
                imageRes = R.drawable.profile,
                name = "Chat Room 4",
                participantsCount = 5,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박원빈", 4, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(2, imageRes = R.drawable.profile, "김수빈", 4, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "원빈", 3, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(4, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 5,
                imageRes = R.drawable.profile,
                name = "Chat Room 5",
                participantsCount = 8,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                    EmployeeData(id = "hgd",name = "홍길동", position = "사원"),
                    EmployeeData(id = "hsj",name = "홍수진", position = "사원"),
                    EmployeeData(id = "khw",name = "강형욱", position = "사원"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 4, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 4, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 4, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 3, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 6,
                imageRes = R.drawable.profile,
                name = "Chat Room 6",
                participantsCount = 6,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                    EmployeeData(id = "hgd",name = "홍길동", position = "사원"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 4, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 3, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 3, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 1, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 7,
                imageRes = R.drawable.profile,
                name = "Chat Room 7",
                participantsCount = 5,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 3, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 3, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 2, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 2, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 8,
                imageRes = R.drawable.profile,
                name = "Chat Room 8",
                participantsCount = 5,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "pwb", name = "박원빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "대리"),
                    EmployeeData(id = "wb", name = "원빈", position = "차장"),
                    EmployeeData(id = "kwb",name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 4, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 4, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 3, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 2, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
        )

        val openChatRoom = listOf(
            ChatRoomData(
                id = 1,
                imageRes = R.drawable.profile,
                name = "Open Chat Room 1",
                participantsCount = 6,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "bms",name = "박민수", position = "사원"),
                    EmployeeData(id = "ojh",name = "오준혁", position = "사원"),
                    EmployeeData(id = "hb",name = "현빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "사원"),
                    EmployeeData(id = "bds",name = "박동수", position = "사원"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박민수", 4, LocalDateTime.now(), "확인했습니다."),
                    ChatData(2, imageRes = R.drawable.profile, "오준혁", 3, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "현빈", 3, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "프로젝트 일정 공유 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "김수빈", 2, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "김수빈 입니다."),
                    ChatData(5, imageRes = R.drawable.profile, "박동수", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "프로젝트 공유 방입니다."),
                )
            ),
            ChatRoomData(
                id = 2,
                imageRes = R.drawable.profile,
                name = "Open Chat Room 2",
                participantsCount = 8,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "bms",name = "박민수", position = "사원"),
                    EmployeeData(id = "ojh",name = "오준혁", position = "사원"),
                    EmployeeData(id = "hb",name = "현빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "사원"),
                    EmployeeData(id = "bds",name = "박동수", position = "사원"),
                    EmployeeData(id = "t1",name = "test1", position = "사원"),
                    EmployeeData(id = "t2",name = "test2", position = "사원"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박민수", 7, LocalDateTime.now(), "확인했습니다."),
                    ChatData(2, imageRes = R.drawable.profile, "오준혁", 5, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "현빈", 4, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "프로젝트 일정 공유 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "김수빈", 3, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "김수빈 입니다."),
                    ChatData(5, imageRes = R.drawable.profile, "박동수", 2, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "프로젝트 공유 방입니다."),
                )
            ),
            ChatRoomData(
                id = 3,
                imageRes = R.drawable.profile,
                name = "Open Chat Room 3",
                participantsCount = 10,
                participants = listOf(
                    EmployeeData(id = "lhj", name = "이형종", position = "사원"),
                    EmployeeData(id = "bms",name = "박민수", position = "사원"),
                    EmployeeData(id = "ojh",name = "오준혁", position = "사원"),
                    EmployeeData(id = "hb",name = "현빈", position = "사원"),
                    EmployeeData(id = "ksb",name = "김수빈", position = "사원"),
                    EmployeeData(id = "bds",name = "박동수", position = "사원"),
                    EmployeeData(id = "t1",name = "test1", position = "사원"),
                    EmployeeData(id = "t2",name = "test2", position = "사원"),
                    EmployeeData(id = "t3",name = "test3", position = "사원"),
                    EmployeeData(id = "t4",name = "test4", position = "사원"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박민수", 5, LocalDateTime.now(), "확인했습니다."),
                    ChatData(2, imageRes = R.drawable.profile, "오준혁", 6, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "현빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "프로젝트 일정 공유 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "김수빈", 8, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "김수빈 입니다."),
                    ChatData(5, imageRes = R.drawable.profile, "박동수", 9, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "프로젝트 공유 방입니다."),
                )
            ),
        )
    }
}