package com.example.cvproject

import CV
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Adapter(
    private val cvList: List<CV>,
    private val databaseHelper: DatabaseHelper,
    private val onItemClick: (CV) -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textFirstName: TextView = itemView.findViewById(R.id.textFirstName)
        val textLastName: TextView = itemView.findViewById(R.id.textLastName)
        val imageView: ImageView = itemView.findViewById(R.id.iv_image)
        val deleteBtn: FloatingActionButton = itemView.findViewById(R.id.imgDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cvList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cv = cvList[position]
        holder.textFirstName.text = cv.firstName
        holder.textLastName.text = cv.lastName
        holder.imageView.setImageResource(R.mipmap.ic_launcher_round)

        holder.itemView.setOnClickListener {
          /*  val bundle = Bundle().apply {
                putString("firstName", cv.firstName)
                putString("lastName", cv.lastName)
                putString("email", cv.email)
                putString("phone", cv.phoneNumber)
                putString("birthDate",cv.birthDate)
                putString("uniName",cv.uniName)
                putString("linkedIn",cv.linkedIn)
            }

            val navController = Navigation.findNavController(holder.itemView)
            navController.navigate(R.id.action_StarFragment_to_ProfileInfoFragment, bundle)*/

            onItemClick(cv)
        }

        holder.deleteBtn.setOnClickListener {
            databaseHelper.deleteCV(cv.id)
            (cvList as MutableList).removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cvList.size)
        }
    }
}
