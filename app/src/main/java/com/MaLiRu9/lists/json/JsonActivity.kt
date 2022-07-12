package com.MaLiRu9.lists.json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.MaLiRu9.lists.databinding.ActivityJsonBinding

class JsonActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityJsonBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createJsonBtn.setOnClickListener () {
            createJsonHandler()
        }
    }

    fun createJsonHandler() {
        val jsonService = JsonService(this)
        jsonService.createJsonFile(
            binding.jsonName.text.toString(),
            binding.exampleCheck.isChecked
        )
    }
}