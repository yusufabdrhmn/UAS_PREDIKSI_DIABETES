package com.example.machinelearning_model_deployment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.machinelearning_model_deployment.databinding.ActivityModelArchitectureBinding

class ModelArchitectureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModelArchitectureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelArchitectureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Arsitektur Model" // Set judul ActionBar
        // Jika Anda memiliki gambar diagram, pastikan sudah ada di res/drawable
        // binding.ivModelDiagram.setImageResource(R.drawable.model_architecture_diagram)
    }
}