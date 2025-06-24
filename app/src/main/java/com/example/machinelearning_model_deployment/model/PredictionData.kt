package com.example.machinelearning_model_deployment.model

/**
 * Data class ini merepresentasikan data input yang akan digunakan untuk prediksi diabetes.
 * Properti di sini harus sesuai dengan fitur-fitur yang digunakan oleh model machine learning Anda.
 *
 * @property age Usia pasien.
 * @property gender Jenis kelamin pasien (misal: 0 untuk Female, 1 untuk Male setelah One-Hot Encoding).
 * @property bmi Indeks Massa Tubuh pasien.
 * @property chol Tingkat Kolesterol pasien.
 * @property tg Tingkat Trigliserida pasien.
 * @property hdl Tingkat High-Density Lipoprotein (HDL) pasien.
 * @property ldl Tingkat Low-Density Lipoprotein (LDL) pasien.
 * @property cr Tingkat Creatinine pasien.
 * @property bun Tingkat Blood Urea Nitrogen (BUN) pasien.
 */
data class PredictionData(
    val age: Float,
    val gender: Float, // Akan jadi 0.0f atau 1.0f setelah One-Hot Encoding
    val bmi: Float,
    val chol: Float,
    val tg: Float,
    val hdl: Float,
    val ldl: Float,
    val cr: Float,
    val bun: Float
)