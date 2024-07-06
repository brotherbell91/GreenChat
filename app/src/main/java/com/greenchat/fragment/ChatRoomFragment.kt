package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.greenchat.data.ChatRoomListData


class ChatRoomFragment : Fragment() {

    companion object {
        private const val ARG_CHATROOM = "chatRoomData"
        private const val ARG_TYPE = "chatRoomType"

        fun newInstance(chatRoomListData: ChatRoomListData, type: Int): ChatRoomFragment {
            val fragment = ChatRoomFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_CHATROOM, chatRoomListData)
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
                val chatRoomListData = arguments?.getParcelable(ARG_CHATROOM) as? ChatRoomListData
                val chatRoomType = arguments?.getInt(ChatRoomFragment.ARG_TYPE)
                val chatRooms = if (chatRoomType == 0) ChatRoomListData.chatRooms else ChatRoomListData.openChatRooms


            }
        }
    }
}