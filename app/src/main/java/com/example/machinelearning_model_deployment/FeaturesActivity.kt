package com.orhan.machinelearning_model_deployment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.machinelearning_model_deployment.databinding.ActivityFeaturesBinding

class FeaturesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeaturesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeaturesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Fitur Aplikasi" // Set judul ActionBar
    }
}