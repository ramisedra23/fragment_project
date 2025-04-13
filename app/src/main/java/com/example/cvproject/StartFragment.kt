package com.example.cvproject

import CV
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cvproject.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: Adapter
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var cvList: MutableList<CV>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseHelper = DatabaseHelper(requireContext())

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        cvList = databaseHelper.getAllCV().toMutableList()

        adapter = Adapter(cvList, databaseHelper) { selectedCV ->
            val bundle = Bundle().apply {
                putString("firstName", selectedCV.firstName)
                putString("lastName", selectedCV.lastName)
                putString("email", selectedCV.email)
                putString("phone", selectedCV.phoneNumber)
                putString("birthDate",selectedCV.birthDate)
                putString("uniName",selectedCV.uniName)
                putString("linkedIn",selectedCV.linkedIn)
            }
            findNavController().navigate(R.id.action_StarFragment_to_ProfileInfoFragment, bundle)
        }

        binding.recyclerView.adapter = adapter

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_StartFragment_to_AddNoteFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        refreshCVList()
    }

    private fun refreshCVList() {
        cvList.clear()
        cvList.addAll(databaseHelper.getAllCV())
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}