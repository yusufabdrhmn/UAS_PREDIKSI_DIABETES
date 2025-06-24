package com.example.machinelearning_model_deployment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.machinelearning_model_deployment.databinding.ActivityAboutAppBinding

class AboutAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Tentang Aplikasi" // Set judul ActionBar
    }
}