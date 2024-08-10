package com.greenchat.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.greenchat.compose.MessageEditScreen
import com.greenchat.data.EmployeeData

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