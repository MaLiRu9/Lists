package com.MaLiRu9.lists.json

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.MaLiRu9.lists.databinding.ActivityJsonBinding

class JsonActivity : AppCompatActivity() {
    private var _binding: ActivityJsonBinding? = null
    private val binding get() = _binding!!

    private lateinit var jsonListAdapter: JsonListAdapter
    private lateinit var jsonList: List<JsonItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jsonList = JsonService(this).getFileList()
        jsonListAdapter = JsonListAdapter(jsonList)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.fileListContainer.layoutManager = layoutManager
        binding.fileListContainer.adapter = jsonListAdapter

        binding.createJsonBtn.setOnClickListener {
            createJsonHandler()
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun createJsonHandler() {
        val jsonService = JsonService(this)
        jsonService.createJsonFile(
            binding.jsonName.text.toString(),
            binding.exampleCheck.isChecked
        )
    }
}