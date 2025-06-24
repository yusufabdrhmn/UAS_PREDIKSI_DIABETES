package com.example.machinelearning_model_deployment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.machinelearning_model_deployment.databinding.ActivitySimulationBinding
import com.example.machinelearning_model_deployment.Constants
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class SimulationActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimulationBinding
    private var tfliteInterpreter: Interpreter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimulationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Simulasi Prediksi"

        try {
            tfliteInterpreter = Interpreter(loadModelFile())
            Toast.makeText(this, "Model diabetes berhasil dimuat!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Gagal memuat model: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }

        binding.btnPredict.setOnClickListener {
            performPrediction()
        }
    }

    private fun loadModelFile(): MappedByteBuffer {
        val fileName = "model_diabetes (1).tflite"
        val fileDescriptor = assets.openFd(fileName)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    private fun performPrediction() {
        if (tfliteInterpreter == null) {
            Toast.makeText(this, "Model belum dimuat. Mohon coba lagi.", Toast.LENGTH_SHORT).show()
            return
        }

        val age = binding.etAge.text.toString().toFloatOrNull()
        val bmi = binding.etBmi.text.toString().toFloatOrNull()
        val chol = binding.etChol.text.toString().toFloatOrNull()
        val tg = binding.etTg.text.toString().toFloatOrNull()
        val hdl = binding.etHdl.text.toString().toFloatOrNull()
        val ldl = binding.etLdl.text.toString().toFloatOrNull()
        val cr = binding.etCr.text.toString().toFloatOrNull()
        val bun = binding.etBun.text.toString().toFloatOrNull()
        val glucose = binding.etGlucose.text.toString().toFloatOrNull()
        val genderValue = if (binding.rbGenderMale.isChecked) 1.0f else 0.0f

        if (age == null || bmi == null || chol == null || tg == null ||
            hdl == null || ldl == null || cr == null || bun == null || glucose == null) {
            Toast.makeText(this, "Harap lengkapi semua data input.", Toast.LENGTH_SHORT).show()
            return
        }

        val rawInput = floatArrayOf(age, bmi, chol, tg, hdl, ldl, cr, bun, genderValue, glucose)

        val scaledInput = FloatArray(rawInput.size)
        for (i in rawInput.indices) {
            if (i < Constants.MEAN_VALUES.size && i < Constants.STD_VALUES.size) {
                scaledInput[i] = (rawInput[i] - Constants.MEAN_VALUES[i]) / Constants.STD_VALUES[i]
            } else {
                Toast.makeText(this, "Error: Konfigurasi scaling tidak cocok dengan jumlah fitur.", Toast.LENGTH_LONG).show()
                return
            }
        }

        val inputBuffer = ByteBuffer.allocateDirect(scaledInput.size * 4).apply {
            order(ByteOrder.nativeOrder())
            asFloatBuffer().put(scaledInput)
        }

        val output = Array(1) { FloatArray(1) }
        tfliteInterpreter?.run(inputBuffer, output)

        val predictionProbability = output[0][0]
        val predictionText: String
        val threshold = 0.5f

        predictionText = if (predictionProbability >= threshold) {
            "Risiko Diabetes: TINGGI\nProbabilitas: ${"%.2f".format(predictionProbability * 100)}%"
        } else {
            "Risiko Diabetes: RENDAH\nProbabilitas: ${"%.2f".format((1 - predictionProbability) * 100)}%"
        }

        binding.tvPredictionResult.text = "Hasil Prediksi:\n$predictionText"
        Toast.makeText(this, "Prediksi selesai!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        tfliteInterpreter?.close()
    }
}
