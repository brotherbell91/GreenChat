package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.greenchat.compose.ProfileScreen
import com.greenchat.data.EmployeeData

class ProfileFragment : Fragment() {

    companion object {
        private const val ARG_EMPLOYEE = "EmployeeData"

        fun newInstance(employeeData: EmployeeData): ProfileFragment {
            val fragment = ProfileFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_EMPLOYEE, employeeData)
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
                val employeeData = arguments?.getParcelable(ARG_EMPLOYEE) as? EmployeeData
                employeeData?.let { ProfileScreen(it) }
            }
        }
    }
}