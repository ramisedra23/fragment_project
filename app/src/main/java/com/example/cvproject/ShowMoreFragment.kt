package com.example.cvproject

import CV
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
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.cvproject.databinding.FragmentShowmoreBinding

class ShowMoreFragment : Fragment(R.layout.fragment_showmore) {

    private lateinit var binding: FragmentShowmoreBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        binding = FragmentShowmoreBinding.bind(view)

        // Retrieve data from arguments
        val birthDate = arguments?.getString("BIRTH_DATE") ?: "Not Provided"
        val university = arguments?.getString("UNIVERSITY") ?: "Not Provided"
        val linkedIn = arguments?.getString("LINKEDIN_URL") ?: ""

        // Display the retrieved data in the TextViews
        binding.birthDate.setText("$birthDate")
        binding.uniName.setText("$university")

        binding.openLinkedin.setOnClickListener {
            if (linkedIn.isNotEmpty()) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedIn))
                startActivity(browserIntent)
            } else {
                Toast.makeText(requireContext(), "LinkedIn URL not provided", Toast.LENGTH_SHORT).show()
            }
        }
    }
}