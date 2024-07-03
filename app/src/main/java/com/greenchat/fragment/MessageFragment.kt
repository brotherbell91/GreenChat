package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.greenchat.compose.MessageScreen
import com.greenchat.data.MessageData

class MessageFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MessageScreen(messageData = MessageData.receiveMessage)
            }
        }
    }
}