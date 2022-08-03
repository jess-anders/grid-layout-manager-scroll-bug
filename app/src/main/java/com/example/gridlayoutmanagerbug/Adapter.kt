package com.example.gridlayoutmanagerbug

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.text)
        val innerBackground: View = view.findViewById(R.id.inner_background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = "position $position"
        holder.innerBackground.isVisible = true
        holder.itemView.setBackgroundColor(if ((position % 2 ) == 0) Color.GREEN else Color.RED)
        holder.itemView.setOnClickListener {
            holder.innerBackground.isVisible = !holder.innerBackground.isVisible
        }
    }

    override fun getItemCount() = 50
}