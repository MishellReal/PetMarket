package com.example.deber04


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_services.*
import android.content.Intent as Intent1


class menuPrincipalFragment : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_principal, container, false)
        //controlador()




    }

    /*fun controlador() {
        val btnPaseo = buttonPaseo as Button
        //hago clic y se abre el 2
        btnPaseo.setOnClickListener {
            //val intent = Intent(this@menuPrincipalFragment,Take_a_walk::class.java)
            val intent = Intent(this@menuPrincipalFragment, Take_a_walk::class.java)
            startActivity(intent)
        }
    }*/







}
