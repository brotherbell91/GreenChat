package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.greenchat.MainActivity
import com.greenchat.compose.ChatRoomScreen
import com.greenchat.data.ChatRoomData
import com.greenchat.data.ChatRoomListData
import com.greenchat.util.Constants

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
                requireActivity().onBackPressedDispatcher.addCallback(
                    viewLifecycleOwner,
                    object : OnBackPressedCallback(true) {
                        override fun handleOnBackPressed() {
                            (activity as MainActivity).removeTopFragment(Constants.CHATROOM_FRAGMENT_TAG)
                        }
                    }
                )

                val chatRoomListData = arguments?.getParcelable(ARG_CHATROOM) as? ChatRoomListData
                val chatRoomType = arguments?.getInt(ChatRoomFragment.ARG_TYPE)
                val chatRooms = if (chatRoomType == 0) ChatRoomData.chat else ChatRoomData.openChat

                chatRoomListData?.let { listData ->
                    val chatRoomData = findChatRoomDataById(chatRooms, listData.id)
                    chatRoomData?.let {
                        ChatRoomScreen(chatRoomData = it)
                    }
                }
            }
        }
    }

    private fun findChatRoomDataById(chatRooms: List<ChatRoomData>, id: Int): ChatRoomData? {
        var low = 0
        var high = chatRooms.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val midVal = chatRooms[mid]

            when {
                midVal.id < id -> low = mid + 1
                midVal.id > id -> high = mid - 1
                else -> return midVal
            }
        }
        return null
    }
}