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
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController

class ShowMore_Fragment : Fragment(R.layout.fragment_showmore) {

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
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://jo.linkedin.com/in/rami-raed-02b0b7225")
            )
            startActivity(intent)
        }

        return view
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val birthDate = arguments?.getString("birthDate")
        val universityName = arguments?.getString("universityName")
        val linkedIn = arguments?.getString("linkedIn")
        val btnLinkedIn: Button = view.findViewById(R.id.open_linkedin)

            if (birthDate != null) {
                view.findViewById<EditText>(R.id.birth_date).setText(birthDate)
            }
            if (universityName != null) {
                view.findViewById<EditText>(R.id.uni_name).setText(universityName)
            }
            if(linkedIn!= null){
                btnLinkedIn.setOnClickListener {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/suhaib-kamal-2b8b1346/")
                    )
                    startActivity(intent)
            }
        }
    }
}