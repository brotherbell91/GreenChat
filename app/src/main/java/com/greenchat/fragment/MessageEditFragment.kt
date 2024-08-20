package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
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

                val employeeDataList = remember { mutableStateListOf<EmployeeData>() }

                setFragmentResultListener("buddyRequestKey") { _, bundle ->
                    val getSelectBuddy = bundle.getParcelable<EmployeeData>("selectBuddy")
                    if (getSelectBuddy != null) {
                        employeeDataList.add(getSelectBuddy)
                    }
                }

                val employeeData = arguments?.getParcelable(ARG_MESSAGE_EDIT) as? EmployeeData
                if (employeeData != null) {
                    employeeDataList.add(employeeData)
                }
                MessageEditScreen(employeeDataList, EmployeeData.myData)
            }
        }
    }
}