package com.Faza.myapplication.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.Faza.myapplication.R
import com.Faza.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding
        private var isGrid = true
        private val arrayString = arrayListOf<String>("Andrea", "Nathan", "Dea")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setupRecyclerView(isGrid)
            setupActionChangeLayout()
        }

        fun setupRecyclerView(isGrid: Boolean) {
            binding.adapter = MenuAdapter(isGrid, arrayString)
            if (isGrid) {
                binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
            } else {
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }

        fun setupActionChangeLayout() {
            //button diklik
            binding.changeLayout.setOnClickListener {
                isGrid = !isGrid
                setupRecyclerView(isGrid)
            }
        }
    }

}