package com.MaLiRu9.lists

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.MaLiRu9.lists.config.ConfigService
import com.MaLiRu9.lists.databinding.ActivityMainBinding
import com.MaLiRu9.lists.views.listmanagement.JsonActivity
import com.MaLiRu9.lists.views.login.LoginActivity
import com.MaLiRu9.lists.storage.StorageTypes

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val config = ConfigService(this)
//when (config.getSelectedStorage())
        when (StorageTypes.FIREBASE) {
            StorageTypes.FIREBASE ->
                startActivity(Intent(this, LoginActivity::class.java))
            else -> {
                val defaultFile = config.getDefaultFileName()
                if (defaultFile.isNullOrBlank()) {
                    startActivity(Intent(this, JsonActivity::class.java))
                } else {
                    val intent = Intent(this, JsonActivity::class.java)
                    intent.putExtra("fileName", defaultFile)
                    startActivity(intent)
                }
            }

            /*
            val database =
                Firebase.database("https://maliru9-lists-default-rtdb.europe-west1.firebasedatabase.app/")
            val reference = database.getReference("message")
            reference.setValue("Hello world!")
            */
        }
    }
}
