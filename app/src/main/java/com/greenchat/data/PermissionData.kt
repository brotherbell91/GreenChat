package com.greenchat.data

data class PermissionData(
    var name: String = "",
    var description: String = "",
){
    companion object {
        val permissions = listOf(
            PermissionData("카메라", "카메라에 접근하여 사진을 촬영할 수 있습니다."),
            PermissionData("위치", "위치 정보에 접근하여 현재 위치를 확인할 수 있습니다."),
            PermissionData("저장소", "저장소에 접근하여 파일을 읽고 쓸 수 있습니다."),
            PermissionData("알림", "메신저의 알림을 수신 및 발신 할 수 있습니다."),
            PermissionData("전화", "인증상태를 유지하고 지속적으로 이용할 수 있습니다."),
            PermissionData("연락처", "연락처에 접근하여 연락처를 사용할 수 있습니다."),
            PermissionData("마이크", "마이크에 접근하여 마이크를 사용할 수 있습니다."),
        )
    }
}