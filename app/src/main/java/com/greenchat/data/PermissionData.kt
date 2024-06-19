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
            PermissionData("카메라", "카메라에 접근하여 사진을 촬영할 수 있습니다."),
            PermissionData("위치", "위치 정보에 접근하여 현재 위치를 확인할 수 있습니다."),
            PermissionData("카메라", "카메라에 접근하여 사진을 촬영할 수 있습니다."),
        )
    }
}