package com.example.cvproject

import CV
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cvproject.databinding.FragmentAddNoteBinding


class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseHelper = DatabaseHelper(requireContext())

        binding.buttonDone.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString().trim()
            val lastName = binding.editTextLastName.text.toString().trim()
            val email = binding.editTextEmail.text.toString().trim()
            val phone = binding.editTextPhoneNumber.text.toString().trim()
            val birthDate = binding.editTextBirthDate.text.toString().trim()
            val university = binding.editTextUniversityName.text.toString().trim()
            val linkedIn = binding.editTextLinkedIn.text.toString().trim()

            if (firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(requireContext(), "First and Last name are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newCV = CV(
                firstName = firstName,
                lastName = lastName,
                email = email,
                phoneNumber = phone,
                birthDate = birthDate,
                uniName = university,
                linkedIn = linkedIn
            )

            val result = databaseHelper.addCV(newCV)

            if (result) {
                Toast.makeText(requireContext(), "CV added successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_AddNoteFragment_to_StartFragment)
            } else {
                Toast.makeText(requireContext(), "Failed to add CV", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}