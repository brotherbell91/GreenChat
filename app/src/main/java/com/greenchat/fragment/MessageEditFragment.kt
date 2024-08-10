package com.greenchat.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.greenchat.MainActivity
import com.greenchat.compose.MessageEditScreen
import com.greenchat.data.EmployeeData
import com.greenchat.util.Constants

class MessageEditFragment : Fragment() {

    companion object {
        private const val ARG_MESSAGE_EDIT = "employeeData"

        fun newInstance(employeeData: EmployeeData): MessageEditFragment {
            val fragment = MessageEditFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_MESSAGE_EDIT, employeeData)
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
                            (activity as MainActivity).removeTopFragment(Constants.MESSAGE_EDIT_FRAGMENT_TAG)
                        }
                    }
                )

                val employeeData = arguments?.getParcelable(ARG_MESSAGE_EDIT) as? EmployeeData
                if (employeeData == null) {
                    MessageEditScreen(EmployeeData.emptyData, EmployeeData.myData)
                } else {
                    MessageEditScreen(employeeData, EmployeeData.myData)
                }
            }
        }
    }
}