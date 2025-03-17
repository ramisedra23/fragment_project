package com.example.cvproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private var isFragmentVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowMore: Button = findViewById(R.id.fragment1btn)
        val fragmentcontainer: View = findViewById(R.id.fragmentcontainer)

        btnShowMore.setOnClickListener {
            btnShowMore.isEnabled = false
            replaceFragment(MoreInfoFragment())

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentcontainer, fragment)
        transaction.commit()
    }
}