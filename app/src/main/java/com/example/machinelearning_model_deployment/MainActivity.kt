package com.example.machinelearning_model_deployment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.machinelearning_model_deployment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnAboutApp.setOnClickListener {
            startActivity(Intent(this, AboutAppActivity::class.java))
        }
        binding.btnFeatures.setOnClickListener {
            startActivity(Intent(this, FeaturesActivity::class.java))
        }
        binding.btnModelArchitecture.setOnClickListener {
            startActivity(Intent(this, ModelArchitectureActivity::class.java))
        }
        binding.btnDataset.setOnClickListener { // BARU: Listener untuk tombol Dataset
            startActivity(Intent(this, DatasetActivity::class.java))
        }
        binding.btnSimulation.setOnClickListener {
            startActivity(Intent(this, SimulationActivity::class.java))
        }
    }
}