package com.example.cvproject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController

class MoreInfoFragment : Fragment(R.layout.fragment_showmore) {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_showmore, container, false)

        val btnLinkedIn: Button = view.findViewById(R.id.open_linkedin)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        btnLinkedIn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://jo.linkedin.com/in/rami-raed-02b0b7225"))
            startActivity(intent)
        }




        return view
    }
}