package com.Faza.myapplication.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.Faza.myapplication.R
import com.Faza.myapplication.databinding.FragmentHomeBinding
import com.Faza.myapplication.model.Menu

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView = binding.rvListMenu
        val isGrid = true

        recyclerView.layoutManager = if (isGrid) GridLayoutManager(requireContext(), 2) else LinearLayoutManager(requireContext())

        val menuAdapter = MenuAdapter(isGrid, data = getMenuData())

        // Set the click listener for the menu items
        menuAdapter.setOnItemClickListener { menu ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(menu)
            findNavController().navigate(action)
        }
        recyclerView.adapter = menuAdapter

        return view
    }

    private fun getMenuData(): List<Menu> {
        return listOf(
            Menu("Ayam Bakar", "Rp 50.000", R.drawable.ayam_bakar, "Ayam bakar dengan olesan madu dan daging empuk"),
            Menu("Ayam Goreng", "Rp 40.000", R.drawable.ayam_goreng, "Ayam Goreng dengan tekstur renyah dan kenyal"),
            Menu("Ayam Geprek", "Rp 40.000", R.drawable.ayam_geprek, "Ayam geprek dengan sambel matah yang menggugah selera"),
            Menu("Sate Usus Ayam", "Rp 5.000", R.drawable.sate_usus_ayam, "Sate usus untuk menemani makan mu tiga kali sehari, Seven days a week!!!")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
