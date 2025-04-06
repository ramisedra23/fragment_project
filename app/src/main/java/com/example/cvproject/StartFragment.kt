package com.example.cvproject

import UserData
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val button = view.findViewById<Button>(R.id.see_InfoBtn)

        button.setOnClickListener {
            val user = UserData()
            val action = StartFragmentDirections.actionStarFragmentToProfileInfoFragment(user)
            findNavController().navigate(action)
        }
    }
}


