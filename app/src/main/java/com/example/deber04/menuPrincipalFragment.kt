package com.example.deber04


import android.net.Uri
import android.os.Bundle
import android.view.FrameMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.FrameMetricsAggregator
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.deber04.ui.gallery.GalleryViewModel
import com.example.deber04.ui.paseo.paseoFragment
import kotlinx.android.synthetic.main.activity_services.*
import android.content.Intent as Intent1


class menuPrincipalFragment : Fragment() {


    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_principal, container, false)


    }






}
