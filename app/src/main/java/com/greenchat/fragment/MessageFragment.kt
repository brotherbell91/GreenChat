package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.greenchat.compose.MessageScreen
import com.greenchat.data.MessageData
import com.greenchat.data.MessageListData

class MessageFragment : Fragment() {

    companion object {
        private const val ARG_MESSAGE = "messageData"
        private const val ARG_TYPE = "messageType"

        fun newInstance(messageListData: MessageListData, type: Int): MessageFragment {
            val fragment = MessageFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_MESSAGE, messageListData)
                putInt(ARG_TYPE, type)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val messageListData = arguments?.getParcelable(ARG_MESSAGE) as? MessageListData
                val messageType = arguments?.getInt(ARG_TYPE)
                val messages = if (messageType == 0) MessageData.receiveMessage else MessageData.sendMessage

                messageListData?.let { listData ->
                    val messageData = findMessageDataById(messages, listData.id)
                    messageData?.let {
                        MessageScreen(messageData = it)
                    }
                }
            }
        }
    }

    private fun findMessageDataById(messages: List<MessageData>, id: Int): MessageData? {
        var low = 0
        var high = messages.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val midVal = messages[mid]

            when {
                midVal.id < id -> low = mid + 1
                midVal.id > id -> high = mid - 1
                else -> return midVal
            }
        }
        return null
    }
}