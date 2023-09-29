package com.Faza.myapplication.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.Faza.myapplication.databinding.FragmentDetailBinding
import com.Faza.myapplication.model.Menu

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        // Menerima argumen Menu
        val menu = arguments?.getParcelable<Menu>("menu")

        // Tampilkan detail menu di tampilan
        binding.tvDetailName.text = menu?.name
        binding.tvDetailPrice.text = menu?.price
        binding.ivDetailImage.setImageResource(menu?.image ?: 0)
        binding.tvDetaildesk.text = menu?.desc

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val menu = args.menu

        // Gunakan objek menu sesuai kebutuhan
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
