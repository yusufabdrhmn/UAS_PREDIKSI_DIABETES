package com.example.machinelearning_model_deployment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.machinelearning_model_deployment.databinding.ActivityDatasetBinding

class DatasetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatasetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatasetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Informasi Dataset" // Set judul ActionBar

        // === PENTING: ISI NILAI NYATA DARI DATASET ANDA ===
        // Berdasarkan df.head() yang Anda berikan, Anda bisa mengisi ini:
        // Jumlah Kolom Awal: 11 (termasuk Unnamed: 0 dan Diagnosis)
        // Setelah drop Unnamed: 0 dan Diagnosis, serta one-hot Gender, input ke model ada 9.
        // Jumlah Baris: Anda harus tahu dari script Python Anda (biasanya 768 untuk PIMA, tapi Anda pakai dataset lain).
        binding.tvDatasetRowsCols.text = "Jumlah Baris: [ISI_JUMLAH_BARIS_ANDA], Jumlah Kolom: 11 (awal), 9 (fitur model)"

        // Jika Anda ingin menampilkan nama fitur dalam format yang lebih terstruktur
        // Anda bisa menggunakan string dari Constants.kt atau menuliskannya di sini
        binding.tvDatasetFeatures.text = "Fitur: Age, Gender, BMI, Chol, TG, HDL, LDL, Cr, BUN, Diagnosis (Target)"


        // === PENTING: PASTIKAN GAMBAR EDA ANDA ADA DI RES/DRAWABLE ===
        // Anda perlu mengekspor 5 grafik EDA Anda dari Python dan menyimpannya di:
        // app/src/main/res/drawable/
        // Dengan nama file seperti eda_graph1.png, eda_graph2.png, dst.
        // Contoh:
        // binding.ivEdaGraph1.setImageResource(R.drawable.eda_graph1)
        // binding.ivEdaGraph2.setImageResource(R.drawable.eda_graph2)
        // binding.ivEdaGraph3.setImageResource(R.drawable.eda_graph3)
        // binding.ivEdaGraph4.setImageResource(R.drawable.eda_graph4)
        // binding.ivEdaGraph5.setImageResource(R.drawable.eda_graph5)
    }
}