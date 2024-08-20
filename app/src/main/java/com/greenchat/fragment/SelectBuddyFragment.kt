package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.greenchat.MainActivity
import com.greenchat.compose.SelectBuddyScreen
import com.greenchat.data.EmployeeData
import com.greenchat.util.Constants

class SelectBuddyFragment : Fragment() {

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
                            (activity as MainActivity).removeTopFragment(Constants.SELECT_BUDDY_FRAGMENT_TAG)
                        }
                    }
                )

                val onSelectBuddy: (EmployeeData) -> Unit = { selectBuddy ->
                    val bundle = Bundle().apply {
                        putParcelable("selectBuddy", selectBuddy)
                    }
                    setFragmentResult("buddyRequestKey", bundle)
                    (activity as MainActivity).removeTopFragment(Constants.SELECT_BUDDY_FRAGMENT_TAG)
                }

                SelectBuddyScreen(openDashboard = onSelectBuddy)
            }
        }
    }
}