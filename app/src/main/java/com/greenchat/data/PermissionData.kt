package com.greenchat.data

data class PermissionData(
    var name: String = "",
    var description: String = "",
){
    companion object {
        val permissions = listOf(
            PermissionData("Camera", "Allows access to the camera to take photos."),
            PermissionData("Location", "Allows access to location information to determine your current location."),
            PermissionData("Storage", "Allows access to storage to read and write files."),
            PermissionData("Notifications", "Allows receiving and sending notifications from the messenger."),
            PermissionData("Phone", "Allows maintaining authentication status for continuous use."),
            PermissionData("Contacts", "Allows access to contacts to use them."),
            PermissionData("Microphone", "Allows access to the microphone to use it."),
            )
    }
}