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
        val chat = listOf(
            ChatRoomData(
                id = 1,
                imageRes = R.drawable.profile,
                name = "Chat Room 1",
                participantsCount = 10,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 2,
                imageRes = R.drawable.profile,
                name = "Chat Room 2",
                participantsCount = 5,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 3,
                imageRes = R.drawable.profile,
                name = "Chat Room 3",
                participantsCount = 8,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 4,
                imageRes = R.drawable.profile,
                name = "Chat Room 4",
                participantsCount = 8,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 5,
                imageRes = R.drawable.profile,
                name = "Chat Room 5",
                participantsCount = 8,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 6,
                imageRes = R.drawable.profile,
                name = "Chat Room 6",
                participantsCount = 8,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 7,
                imageRes = R.drawable.profile,
                name = "Chat Room 7",
                participantsCount = 10,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
            ChatRoomData(
                id = 8,
                imageRes = R.drawable.profile,
                name = "Chat Room 8",
                participantsCount = 5,
                participants = listOf(
                    EmployeeData(name = "이형종", position = "사원"),
                    EmployeeData(name = "박원빈", position = "사원"),
                    EmployeeData(name = "김수빈", position = "대리"),
                    EmployeeData(name = "원빈", position = "차장"),
                    EmployeeData(name = "김우빈", position = "이사"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "이형종", 9, LocalDateTime.now(), "감사합니다."),
                    ChatData(2, imageRes = R.drawable.profile, "박원빈", 8, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "현황 공유 전달드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "김수빈", 7, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "일정 확인 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "원빈", 6, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "반가워요"),
                    ChatData(5, imageRes = R.drawable.profile, "김우빈", 1, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "안녕하세요"),
                )
            ),
        )

        val openChat = listOf(
            ChatRoomData(
                id = 1,
                imageRes = R.drawable.profile,
                name = "Open Chat Room 1",
                participantsCount = 20,
                participants = listOf(
                    EmployeeData(name = "Green", position = "CEO"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박민수", 19, LocalDateTime.now(), "확인했습니다."),
                    ChatData(2, imageRes = R.drawable.profile, "오준혁", 18, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "현빈", 17, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "프로젝트 일정 공유 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "김수빈", 12, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "김수빈 입니다."),
                    ChatData(5, imageRes = R.drawable.profile, "박동수", 8, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "프로젝트 공유 방입니다."),
                )
            ),
            ChatRoomData(
                id = 2,
                imageRes = R.drawable.profile,
                name = "Open Chat Room 2",
                participantsCount = 15,
                participants = listOf(
                    EmployeeData(name = "Green", position = "CEO"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박민수", 19, LocalDateTime.now(), "확인했습니다."),
                    ChatData(2, imageRes = R.drawable.profile, "오준혁", 18, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "현빈", 17, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "프로젝트 일정 공유 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "김수빈", 12, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "김수빈 입니다."),
                    ChatData(5, imageRes = R.drawable.profile, "박동수", 8, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "프로젝트 공유 방입니다."),
                )
            ),
            ChatRoomData(
                id = 3,
                imageRes = R.drawable.profile,
                name = "Open Chat Room 3",
                participantsCount = 12,
                participants = listOf(
                    EmployeeData(name = "Green", position = "CEO"),
                ),
                chats = listOf(
                    ChatData(1, imageRes = R.drawable.profile, "박민수", 19, LocalDateTime.now(), "확인했습니다."),
                    ChatData(2, imageRes = R.drawable.profile, "오준혁", 18, LocalDateTime.of(2024, 7,7, 9, 16,11 ), "확인 부탁드립니다."),
                    ChatData(3, imageRes = R.drawable.profile, "현빈", 17, LocalDateTime.of(2024, 7,6, 3, 12,25 ), "프로젝트 일정 공유 부탁드립니다."),
                    ChatData(4, imageRes = R.drawable.profile, "김수빈", 12, LocalDateTime.of(2024, 6,21, 8, 5,17 ), "김수빈 입니다."),
                    ChatData(5, imageRes = R.drawable.profile, "박동수", 8, LocalDateTime.of(2024, 5,18, 7, 58,53 ), "프로젝트 공유 방입니다."),
                )
            ),
        )
    }
}