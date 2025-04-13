package com.example.cvproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.cvproject.databinding.FragmentProfileBinding


class PersonalInfoFragment : Fragment(R.layout.fragment_profile) {

        private lateinit var binding: FragmentProfileBinding

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding = FragmentProfileBinding.bind(view)

            val firstName = arguments?.getString("firstName") ?: ""
            val lastName = arguments?.getString("lastName") ?: ""
            val email = arguments?.getString("email") ?: ""
            val phone = arguments?.getString("phone") ?: ""
            val birthDate = arguments?.getString("birthDate") ?: ""
            val university = arguments?.getString("uniName") ?: ""
            val linkedIn = arguments?.getString("linkedIn") ?: ""

            binding.firstName.setText(firstName)
            binding.lastName.setText(lastName)
            binding.emailAddress.setText(email)
            binding.phone.setText(phone)


            binding.fragment1btn.setOnClickListener {
                val nextBundle = Bundle().apply {
                    putString("BIRTH_DATE", birthDate) // Take the entered value for birthDate
                    putString("UNIVERSITY", university) // Take the entered value for universityName
                    putString("LINKEDIN_URL",linkedIn) // Take the entered value for LinkedIn URL
                }

                findNavController().navigate(R.id.action_profileFragment_to_moreInfoFragment, nextBundle)
            }
        }
    }

