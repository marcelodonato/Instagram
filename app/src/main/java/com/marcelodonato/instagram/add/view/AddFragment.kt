package com.marcelodonato.instagram.add.view

import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.marcelodonato.instagram.R
import com.marcelodonato.instagram.add.Add
import com.marcelodonato.instagram.common.base.BaseFragment
import com.marcelodonato.instagram.databinding.FragmentAddBinding
import java.util.jar.Manifest

class AddFragment : BaseFragment<FragmentAddBinding, Add.Presenter>(
    R.layout.fragment_add,
    FragmentAddBinding::bind
), Add.View {

    override lateinit var presenter: Add.Presenter

    override fun setupPresenter() {

    }

    override fun setupView() {
        val tabLayout = binding?.addTab
        val viewPager = binding?.addViewpager
        val adapter = AddViewPagerAdapter(requireActivity())
        viewPager?.adapter = adapter

        if (tabLayout != null && viewPager != null) {
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab?.text ==getString(adapter.tabs[0])){
                        startCamera()
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }
            })
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = getString(adapter.tabs[position])
            }.attach()
        }

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            getPermission.launch(REQUIRED_PERMISSION)
        }
    }

    private fun startCamera(){
       setFragmentResult("cameraKey", bundleOf("startCamera" to true))
    }

    private val getPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (allPermissionsGranted()) {
            startCamera()
        }else {
            Toast.makeText(requireContext(),R.string.permission_camera_denied, Toast.LENGTH_LONG).show()
        }
    }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            requireContext(),
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED


    companion object {
        private const val REQUIRED_PERMISSION = android.Manifest.permission.CAMERA
    }
}