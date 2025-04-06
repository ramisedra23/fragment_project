package com.example.cvproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import UserData
import android.annotation.SuppressLint
import android.widget.ImageView

class ProfileInfoFragment : Fragment(R.layout.fragment_profile) {
    @SuppressLint("MissingInflatedId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userData = arguments?.getSerializable("userData") as? UserData

        userData?.let {
            view.findViewById<EditText>(R.id.first_name).setText(it.firstName)
            view.findViewById<EditText>(R.id.last_name).setText(it.lastName)
            view.findViewById<EditText>(R.id.email_address).setText(it.email)
            view.findViewById<EditText>(R.id.phone).setText(it.phoneNumber)
            view.findViewById<ImageView>(R.id.imageview).setImageResource(it.picture)

        }


                val toolbar1 = view.findViewById<Toolbar>(R.id.toolbar1)
                toolbar1.setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
                    val button = view.findViewById<Button>(R.id.fragment1btn)
                    button.setOnClickListener {
                        val user = UserData()
                        val action = ProfileInfoFragmentDirections.actionProfileFragmentToMoreInfoFragment(user)
                        findNavController().navigate(action)
                }
            }
        }


