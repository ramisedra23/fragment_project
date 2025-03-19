package com.example.cvproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.findViewById<Button>(R.id.fragment1btn).setOnClickListener {
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_profileFragment_to_moreInfoFragment)
        }

        return view
    }
}