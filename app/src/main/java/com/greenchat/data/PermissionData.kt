package com.greenchat.data

data class PermissionData(
    var name: String = "",
    var description: String = "",
    var permission: String = "",
    var state: Boolean = false,
){
    companion object {
        val permissions = listOf(
            PermissionData("Camera", "Allows access to the camera to take photos and videos.", android.Manifest.permission.CAMERA, false),
            PermissionData("Precise Location", "Allows access to precise location information to determine your current location.", android.Manifest.permission.ACCESS_FINE_LOCATION, false),
            PermissionData("Approximate Location", "Allows access to approximate location information.", android.Manifest.permission.ACCESS_COARSE_LOCATION, false),
            PermissionData("Microphone", "Allows access to the microphone for voice messages and calls.", android.Manifest.permission.RECORD_AUDIO, false),
            PermissionData("Contacts", "Allows access to your contacts to enhance messaging features.", android.Manifest.permission.READ_CONTACTS, false),
            PermissionData("Notifications", "Allows receiving and sending notifications from the messenger.", android.Manifest.permission.POST_NOTIFICATIONS, false),
            PermissionData("Phone State", "Allows maintaining authentication status for continuous use.", android.Manifest.permission.READ_PHONE_STATE, false),
            PermissionData("Write Storage", "Allows access to storage to write files.", android.Manifest.permission.WRITE_EXTERNAL_STORAGE, false),
            PermissionData("Read Storage", "Allows access to storage to read files.", android.Manifest.permission.READ_EXTERNAL_STORAGE, false),
            PermissionData("Read Audio", "Allows access to read audio files from your device.", android.Manifest.permission.READ_MEDIA_AUDIO, false),
            PermissionData("Read Images", "Allows access to read image files from your device.", android.Manifest.permission.READ_MEDIA_IMAGES, false),
            PermissionData("Read Videos", "Allows access to read video files from your device.", android.Manifest.permission.READ_MEDIA_VIDEO, false),
            )
    }
}