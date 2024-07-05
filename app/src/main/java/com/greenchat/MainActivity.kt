package com.greenchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
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

    fun showTopFragment(fragment: Fragment, tag: String? = null) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .add(R.id.nav_host_fragment, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    fun hideTopFragment() {
        supportFragmentManager.popBackStack()
    }
}