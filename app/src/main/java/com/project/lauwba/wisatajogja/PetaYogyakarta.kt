package com.project.lauwba.wisatajogja

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_peta_yogyakarta.*

class PetaYogyakarta : Fragment(), OnMapReadyCallback, View.OnClickListener {

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment
    lateinit var normal: Button
    lateinit var satelit: Button
    lateinit var hybrid: Button
    lateinit var terrain: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_peta_yogyakarta, null);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mp = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)

        normal = view.findViewById(R.id.normal)
        satelit = view.findViewById(R.id.satelit)
        hybrid = view.findViewById(R.id.hybrid)
        terrain = view.findViewById(R.id.terrain)

        normal.setOnClickListener(this)
        satelit.setOnClickListener(this)
        hybrid.setOnClickListener(this)
        terrain.setOnClickListener(this)


    }

    override fun onMapReady(p0: GoogleMap?) {
        var candi_prambanan: LatLng
        var tugu_jogja: LatLng
        map = p0!!


        candi_prambanan = LatLng(-7.7520206, 110.4892787)
        map.addMarker(MarkerOptions().position(candi_prambanan).title("Candi Prambanan"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(candi_prambanan, 10F))

        tugu_jogja = LatLng(-7.7828893, 110.3648875)
        map.addMarker(MarkerOptions().position(tugu_jogja).title("Tugu Jogja"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tugu_jogja, 10F))


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.satelit -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.hybrid -> {
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.terrain -> {
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
        }
    }
}