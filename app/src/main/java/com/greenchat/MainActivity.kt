package com.greenchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValue()
        setEvent()
    }

    private fun setValue() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    private fun setEvent() {

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController().navigateUp() || super.onSupportNavigateUp()
    }

    private fun findNavController(): NavController {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }

    fun addTopFragment(fragment: Fragment, tag: String? = null) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .add(R.id.first_fragment_container, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }

    fun removeTopFragment(tag: String? = null) {
        supportFragmentManager.beginTransaction().remove(
            supportFragmentManager.findFragmentById(R.id.first_fragment_container)!!
        ).commitNow()
        supportFragmentManager.popBackStackImmediate(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}