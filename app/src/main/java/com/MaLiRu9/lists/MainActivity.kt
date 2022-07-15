package com.MaLiRu9.lists

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.MaLiRu9.lists.config.ConfigService
import com.MaLiRu9.lists.json.JsonActivity
import com.MaLiRu9.lists.list.ListActivity
import com.MaLiRu9.lists.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val config = ConfigService(this)

        if (config.getFireBaseActive()) {
            //TODO gestionar qué hacer si está activo el modo Firebase
        } else {
            val defaultFile = config.getDefaultFileName()
            if (defaultFile.isNullOrBlank()) {
                startActivity(Intent(this, JsonActivity::class.java))
            } else {
                val intent = Intent(this, JsonActivity::class.java)
                intent.putExtra("fileName", defaultFile)
                startActivity(intent)
            }
        }

        val isLogged = false
        if (isLogged) {
            startActivity(Intent(this, ListActivity::class.java).apply { })
            return
        }

        if (config.isLocal()) {
            startActivity(Intent(this, JsonActivity::class.java))
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("isLocal", config.isLocal())
            startActivity(intent)
        }
    }
}
