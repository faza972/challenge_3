package com.Faza.myapplication.detail

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.Faza.myapplication.R
import com.Faza.myapplication.databinding.FragmentDetailBinding
import com.Faza.myapplication.databinding.FragmentHomeBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DetailFragment : Fragment() {
    private lateinit var mapView: MapView
    private lateinit var binding: FragmentDetailBinding
    val args: DetailFragmentArgs by navArgs()
    val menu = args.menu
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        mapView = view.findViewById(R.id.Lokasi)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()

        val latitude = arguments?.getDouble("latiude") ?: 0.0
        val longitude = arguments?.getDouble("longitude") ?: 0.0

        val mapViewBundle = Bundle()
        mapView.onCreate(mapViewBundle)

        mapView.getMapAsync { googleMap ->
            val location = LatLng(latitude, longitude)
            googleMap.addMarker(MarkerOptions().position(location))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        }
        // Inflate the layout for this fragment
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }
    private fun setClickListener() {
        binding.Lokasi.setOnClickListener {
            navigateToGoogleMaps()
        }
    }
    private fun navigateToGoogleMaps() {
        val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:-6.3016,$106.65337"))
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}