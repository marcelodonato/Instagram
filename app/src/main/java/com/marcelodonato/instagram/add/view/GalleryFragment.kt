package com.marcelodonato.instagram.add.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.marcelodonato.instagram.R

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

}