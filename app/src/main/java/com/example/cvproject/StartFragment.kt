package com.example.cvproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController


class StartFragment : Fragment(R.layout.fragment_start) {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.see_InfoBtn).setOnClickListener {
                val action = StartFragmentDirections.actionStarFragmentToProfileInfoFragment();
                action.firstName = "Rami"
                action.lastName = "AL Ashhab"
                action.email = "ramisedra235@gmail.com"
                action.phoneNumber = "+962790167276"
                action.imageUri = "Image"

            findNavController().navigate(action)

        }

    }
}

