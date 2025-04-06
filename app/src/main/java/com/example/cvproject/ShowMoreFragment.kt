package com.example.cvproject

import UserData
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
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController

class ShowMoreFragment : Fragment(R.layout.fragment_showmore) {

    @SuppressLint("MissingInflatedId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val btnLinkedIn: Button = view.findViewById(R.id.open_linkedin)
        val userData = arguments?.getSerializable("userData") as? UserData

        userData?.let {
            view.findViewById<EditText>(R.id.birth_date).setText(it.birthDate)
            view.findViewById<EditText>(R.id.uni_name).setText(it.uniName)
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(it.linkedIn)
            )
            startActivity(intent)
        }

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }


}