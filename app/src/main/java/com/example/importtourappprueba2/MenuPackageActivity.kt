package com.example.importtourappprueba2

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import data.TourPackage

class MenuPackageActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_packages)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val packagesAdapter = PackagesAdapter(this,getPackagesList())
        recyclerView.adapter = packagesAdapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getPackagesList(): List<TourPackage> {
        // Implementa la lógica para obtener la lista de paquetes turísticos
        val packagesList = repositories.PackageRepository.get()
        return packagesList
    }
}