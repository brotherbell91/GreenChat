package com.greenchat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.greenchat.MainActivity
import com.greenchat.compose.ProfileScreen
import com.greenchat.data.EmployeeData
import com.greenchat.util.Constants

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
                requireActivity().onBackPressedDispatcher.addCallback(
                    viewLifecycleOwner,
                    object : OnBackPressedCallback(true) {
                        override fun handleOnBackPressed() {
                            (activity as MainActivity).removeTopFragment(Constants.PROFILE_FRAGMENT_TAG)
                        }
                    }
                )

                val employeeData = arguments?.getParcelable(ARG_EMPLOYEE) as? EmployeeData
                employeeData?.let { ProfileScreen(it) }
            }
        }
    }
}