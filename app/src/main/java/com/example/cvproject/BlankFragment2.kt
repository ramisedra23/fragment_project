package com.example.cvproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ProfileFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)

        val btnShowMore: Button = view.findViewById(R.id.fragment1btn)
        btnShowMore.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentcontainer, MoreInfoFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}