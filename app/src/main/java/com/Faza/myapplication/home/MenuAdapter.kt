package com.Faza.myapplication.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Faza.myapplication.R
import com.Faza.myapplication.databinding.ItemMenuLinearBinding

class MenuAdapter (val isGrid: Boolean, val data: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (isGrid){
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val contactView = inflater.inflate(R.layout.item_menu_grid,parent, false)
            return GridMenuHolder(contactView)
        }else{
            val binding = ItemMenuLinearBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LinearMenuHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isGrid){
            val gridHolder = holder as GridMenuHolder
            gridHolder.onBind(data[position])
        }else{
            val linearHolder = holder as LinearMenuHolder
            linearHolder.onBind(data[position])
        }
    }
}
class GridMenuHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(data: String){
        val grid = itemView.findViewById<TextView>(R.id.tvNameGrid)
        grid.text = data
    }
}
class LinearMenuHolder(val binding: ItemMenuLinearBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: String){
        binding.tvMenuName.text = data
    }
}


