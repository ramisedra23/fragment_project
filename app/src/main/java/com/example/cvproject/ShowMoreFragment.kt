package com.example.cvproject


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.cvproject.databinding.FragmentShowmoreBinding

class ShowMoreFragment : Fragment(R.layout.fragment_showmore) {

    private lateinit var binding: FragmentShowmoreBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentShowmoreBinding.bind(view)

        val birthDate = arguments?.getString("BIRTH_DATE") ?: "Not Provided"
        val university = arguments?.getString("UNIVERSITY") ?: "Not Provided"
        val linkedIn = arguments?.getString("LINKEDIN_URL") ?: ""

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