package com.example.cvproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class ProfileInfo_Fragment : Fragment(R.layout.fragment_profile) {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val toolbar1 = view.findViewById<Toolbar>(R.id.toolbar1)
        toolbar1.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.fragment1btn).setOnClickListener {
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_profileFragment_to_moreInfoFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstName = arguments?.getString("firstName")
        val lastName = arguments?.getString("lastName")
        val email = arguments?.getString("email")
        val phoneNumber = arguments?.getString("phoneNumber")
        val  imageUri= arguments?.getString("imageUri")



        if (firstName!=null){
            view.findViewById<EditText>(R.id.first_name).setText(firstName)
        }
        if (lastName!=null){
            view.findViewById<EditText>(R.id.last_name).setText(lastName)
        }
        if (email!=null){
            view.findViewById<EditText>(R.id.email_address).setText(email)
        }
        if (phoneNumber!=null){
            view.findViewById<EditText>(R.id.phone).setText(phoneNumber)
        }
        if (imageUri != null) {
            view.findViewById<ImageView>(R.id.imageview).setImageResource(R.drawable.ic_launcher_background)
        }

        view.findViewById<Button>(R.id.fragment1btn).setOnClickListener {
            val action = ProfileInfo_FragmentDirections.actionProfileFragmentToMoreInfoFragment();
            action.birthDate = "18/12/2003"
            action.universityName = "al balqa applied university"
            action.linkedIn = "link"
            findNavController().navigate(action)


        }

        //val  = arguments?.getString("")
    }
}