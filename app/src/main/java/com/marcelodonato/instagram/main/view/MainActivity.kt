package com.marcelodonato.instagram.main.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowInsetsController
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.marcelodonato.instagram.R
import com.marcelodonato.instagram.camera.view.CameraFragment
import com.marcelodonato.instagram.common.extension.replaceFragment
import com.marcelodonato.instagram.databinding.ActivityMainBinding
import com.marcelodonato.instagram.home.view.HomeFragment
import com.marcelodonato.instagram.profile.view.ProfileFragment
import com.marcelodonato.instagram.search.view.SearchFragment


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var homeFragment: Fragment
    private lateinit var searchFragment: Fragment
    private lateinit var profileFragment: Fragment
    private lateinit var cameraFragment: Fragment
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = ContextCompat.getColor(this, R.color.gray)
        }


        setSupportActionBar(binding.mainToolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_insta_camera)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        profileFragment = ProfileFragment()
        cameraFragment = CameraFragment()

        currentFragment = homeFragment

        supportFragmentManager.beginTransaction().apply {
            add(R.id.main_fragment, profileFragment, "3").hide(profileFragment)
            add(R.id.main_fragment, cameraFragment, "2").hide(cameraFragment)
            add(R.id.main_fragment, searchFragment, "1").hide(searchFragment)
            add(R.id.main_fragment, homeFragment, "0")
            commit()
        }

        binding.mainBottomNav.setOnNavigationItemSelectedListener(this)
        //   binding.mainBottomNav.selectedItemId = R.id.menu_bottom_home
    }

    private fun setScrollToolbarEnabled(enabled: Boolean) {
        val params = binding.mainToolbar.layoutParams as AppBarLayout.LayoutParams
        var coordinatorParams = binding.mainAppbar.layoutParams as CoordinatorLayout.LayoutParams

        if (enabled) {
            params.scrollFlags =
                AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
            coordinatorParams.behavior = AppBarLayout.Behavior()
            binding.mainAppbar.layoutParams = coordinatorParams

        } else {
            params.scrollFlags = 0
            coordinatorParams.behavior = null
            binding.mainAppbar.layoutParams = coordinatorParams
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var scrollToolbarEnabled = false
        when (item.itemId) {
            R.id.menu_bottom_home -> {
                if (currentFragment == homeFragment) return false
                supportFragmentManager.beginTransaction().hide(currentFragment).show(homeFragment).commit()
                currentFragment = homeFragment

            }
            R.id.menu_bottom_search -> {
                if (currentFragment == searchFragment) return false
                supportFragmentManager.beginTransaction().hide(currentFragment).show(searchFragment).commit()
                currentFragment = searchFragment

            }
            R.id.menu_bottom_profile -> {
                if (currentFragment == profileFragment) return false
                supportFragmentManager.beginTransaction().hide(currentFragment).show(profileFragment).commit()
                currentFragment = profileFragment
                scrollToolbarEnabled = true
            }
            R.id.menu_bottom_add -> {
                if (currentFragment == cameraFragment) return false
                supportFragmentManager.beginTransaction().hide(currentFragment).show(cameraFragment).commit()
                currentFragment = cameraFragment

            }
        }

        setScrollToolbarEnabled(scrollToolbarEnabled)

//        currentFragment?.let {
//            replaceFragment(R.id.main_fragment, it)
//        }

        return true
    }
}