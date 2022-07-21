package com.MaLiRu9.lists

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.MaLiRu9.lists.config.ConfigService
import com.MaLiRu9.lists.databinding.ActivityMainBinding
import com.MaLiRu9.lists.views.listmanagement.JsonActivity
import com.MaLiRu9.lists.views.login.LoginActivity
import com.MaLiRu9.lists.storage.StorageTypes
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val config = ConfigService(this)
        var defaultList: String? = null

        when (config.getSelectedStorage()) {
            StorageTypes.FIREBASE -> {
                //startActivity(Intent(this, LoginActivity::class.java))
                defaultList = config.getDefaultFirebaseNode()
            }
            else -> { //StorageTypes.LOCAL
                defaultList = config.getDefaultFileName()

            }
        }
        if (defaultList.isNullOrBlank()) {
            startActivity(Intent(this, JsonActivity::class.java))
        } else {
            val intent = Intent(this, JsonActivity::class.java)
        }

        /* val database =
            Firebase.database("https://maliru9-lists-default-rtdb.europe-west1.firebasedatabase.app/")
        val reference = database.getReference("message")
        reference.setValue("Hello world!") */


    }
}
